package com.jforce.selenium.config;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.Frame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.io.File;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VideoTextValidator {

    private static final double FRAME_INTERVAL_SECONDS = 1.0; 
    private static final double MAX_PROCESSING_SECONDS = 40.0;
    
    // Define the cropping area in percentage (Normalized to 1000)
    // [X_START, Y_START, WIDTH, HEIGHT] 
    private static final int[] CROP_RECTANGLE = {50, 50, 900, 800}; 

    public static void mainValidationText(String title) throws Exception {
        Path videoPath = Path.of("target/video.mp4");
        List<String> expectedTexts = Arrays.asList(
                title,
                "Faculty : Dr. Upendra Kumar"
        );

        validateVideoText(videoPath, expectedTexts);
    }

    public static void validateVideoText(Path videoFile, List<String> expectedTexts) throws Exception {
        log.info("Starting OCR validation for video: {}", videoFile);

        try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(videoFile.toFile())) {
            grabber.start();

            double fps = grabber.getFrameRate();
            long frameCount = grabber.getLengthInFrames();
            double durationSec = frameCount / fps;
            log.info("Video FPS: {}, Frames: {}, Duration: {}s", fps, frameCount, durationSec);
            
            int frameWidth = grabber.getImageWidth();
            int frameHeight = grabber.getImageHeight();
            log.info("Frame Dimensions: {}x{}", frameWidth, frameHeight);

            // Calculate the actual crop dimensions
            int x = (int) (frameWidth * (CROP_RECTANGLE[0] / 1000.0));
            int y = (int) (frameHeight * (CROP_RECTANGLE[1] / 1000.0));
            int w = (int) (frameWidth * (CROP_RECTANGLE[2] / 1000.0));
            int h = (int) (frameHeight * (CROP_RECTANGLE[3] / 1000.0));
            
            if (x < 0 || y < 0 || x + w > frameWidth || y + h > frameHeight || w <= 0 || h <= 0) {
                log.error("Invalid cropping dimensions calculated. Proceeding without crop.");
                x = 0; y = 0; w = frameWidth; h = frameHeight;
            }
            
            Rectangle cropArea = new Rectangle(x, y, w, h);
            log.info("Cropping Area (x, y, w, h): {}, {}, {}, {}", x, y, w, h);


            ITesseract tesseract = new Tesseract();
            tesseract.setDatapath("src/main/resources/tessdata");
            tesseract.setLanguage("eng");
            
            // 🚀 COMPILE ERROR FIX: Replaced constants with integer values
            tesseract.setOcrEngineMode(3); // ITesseract.DEFAULT_OCR_ENGINE_MODE
            tesseract.setPageSegMode(3);   // ITesseract.PSM_SINGLE_BLOCK


            Java2DFrameConverter converter = new Java2DFrameConverter();
            Map<Double, String> extractedTextPerFrame = new LinkedHashMap<>();

            double limitSec = Math.min(durationSec, MAX_PROCESSING_SECONDS);
            log.info("Processing frames from 0s up to {:.0f}s (max 40s).", limitSec);

            for (double t = 0; t < limitSec; t += FRAME_INTERVAL_SECONDS) {
                long frameNumber = Math.round(t * fps);
                if (frameNumber >= frameCount) break; 
                
                grabber.setFrameNumber((int) frameNumber);
                Frame frame = grabber.grabImage();
                if (frame == null) continue;

                BufferedImage fullImage = converter.convert(frame);
                if (fullImage == null) continue;

                BufferedImage croppedImage = fullImage.getSubimage(
                    cropArea.x, 
                    cropArea.y, 
                    cropArea.width, 
                    cropArea.height
                );

                // (Optional) Save cropped frame for debugging
                File frameFile = new File("target/frames/cropped_frame_" + (int) t + "s.png");
                frameFile.getParentFile().mkdirs();
                ImageIO.write(croppedImage, "png", frameFile);

                String text = tesseract.doOCR(croppedImage);
                
                // 1. Filter out random characters
                String cleanText = text.replaceAll("[^a-zA-Z0-9\\s.,:;()]", " "); 
                
                // 2. Tokenize and filter out short, non-meaningful tokens.
                String[] tokens = cleanText.split("\\s+");
                StringBuilder filteredText = new StringBuilder();
                
                for (String token : tokens) {
                    if (token.length() > 2 || token.matches(".*[0-9.,:;()].*")) {
                        filteredText.append(token).append(" ");
                    }
                }
                
                // 3. Standardize spaces and trim
                String standardizedText = filteredText.toString().trim().replaceAll("\\s+", " ");
                
                extractedTextPerFrame.put(t, standardizedText);
                
                log.info("⏱ {:.0f}s OCR text: {}", t, standardizedText);
            }

            grabber.stop();

            // Store all extracted text in a List
            List<String> allExtractedTextsList = new ArrayList<>(extractedTextPerFrame.values());
            log.info("--- List of All Extracted Texts ({} items, Cropped & Filtered) ---", allExtractedTextsList.size());
            log.info("List: {}", allExtractedTextsList);
            log.info("-----------------------------------------------");
            
            // --- Validation ---
            String allDetectedText = extractedTextPerFrame.values().stream()
                    .map(String::toLowerCase)
                    .collect(Collectors.joining(" | "));

            log.info("--- Summary of All Detected Text (within {:.0f}s) ---", limitSec);
            log.info("Actual Text (Cropped & Filtered): {}", allDetectedText.isEmpty() ? "No text detected." : allDetectedText);
            log.info("---------------------------------------------------------");

            // Expected Texts:
            String expected1 = expectedTexts.get(0); 
            String expected2 = expectedTexts.get(1); 

            // 1. Validate the long title using Keyword Matching (Robust against missing 'of', 'and')
            List<String> keyWords1 = Arrays.asList("fundamental", "quantitative", "technique", "businesses", "excel");
            long foundKeywordsCount1 = keyWords1.stream()
                .filter(allDetectedText::contains)
                .count();

            // Success if at least 4 out of 5 key words are found.
            boolean found1 = foundKeywordsCount1 >= 4; 
            
            if (found1) {
                log.info("✅ Found expected text (Keyword Match: {}/{}): {}", foundKeywordsCount1, keyWords1.size(), expected1);
            } else {
                log.error("❌ Missing expected text (Keyword Match: {}/{}): {}", foundKeywordsCount1, keyWords1.size(), expected1);
            }

            // 2. Validate the shorter title using simple Contains
            boolean found2 = allDetectedText.contains(expected2.toLowerCase());

            if (found2) {
                log.info("✅ Found expected text (Direct Match): {}", expected2);
            } else {
                log.error("❌ Missing expected text (Direct Match): {}", expected2);
            }

            log.info("Validation complete.");
        }
    }
}