package com.jforce.selenium.config;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public final class FFmpegConfig {

    private static final int CONNECT_TIMEOUT_MS = 15_000;
    private static final int READ_TIMEOUT_MS    = 60_000;
    private static final int BUFFER_SIZE        = 256 * 1024; // 256 KiB

    private FFmpegConfig() {}

    // Example usage
    public static void mainMethod(String url) {
    	
    	System.out.println("in side mainMethod ------------------------------------------------------");
        String videoUrl = url; // your dynamic video URL
        Path destination = Paths.get("target/video.mp4");
        try {
            downloadVideo(videoUrl, destination, true); // true = resume if partial exists
            System.out.println("Video downloaded successfully: " + destination.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Download failed: " + e.getMessage());
        }
    }

    public static void downloadVideo(String videoUrl, Path destination) throws IOException {
        downloadVideo(videoUrl, destination, false);
    }

    public static void downloadVideo(String videoUrl, Path destination, boolean resume) throws IOException {
    	
    	System.out.println("in side downloadVideo ----------------------------------------------------");
        if (videoUrl == null || videoUrl.isBlank()) {
            throw new IllegalArgumentException("videoUrl must not be null/blank");
        }
        if (destination == null) {
            throw new IllegalArgumentException("destination must not be null");
        }

        Files.createDirectories(destination.toAbsolutePath().getParent());
        
     // START: Added logic to delete the existing file if not resuming
        if (!resume && Files.exists(destination)) {
            try {
                Files.delete(destination);
                System.out.println("Existing file deleted: " + destination.getFileName());
            } catch (IOException e) {
                // Log or handle the case where deletion fails
                System.err.println("Failed to delete existing file: " + e.getMessage());
                // It might be better to throw the exception here if we cannot proceed
                // throw e;
            }
        }
        // END: Added logic

        long existingBytes = resume && Files.exists(destination) ? Files.size(destination) : 0L;

        HttpURLConnection.setFollowRedirects(true);
        HttpURLConnection connection = (HttpURLConnection) new URL(videoUrl).openConnection();
        connection.setConnectTimeout(CONNECT_TIMEOUT_MS);
        connection.setReadTimeout(READ_TIMEOUT_MS);
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        if (existingBytes > 0) {
            connection.setRequestProperty("Range", "bytes=" + existingBytes + "-");
        }

        connection.connect();

        int status = connection.getResponseCode();
        boolean ok = status == HttpURLConnection.HTTP_OK;           // 200
        boolean partial = status == HttpURLConnection.HTTP_PARTIAL; // 206
        if (!(ok || partial)) {
            connection.disconnect();
            throw new IOException("Server returned HTTP " + status);
        }

        // If server ignored Range, start from scratch
        if (existingBytes > 0 && ok) {
            existingBytes = 0;
        }

        try (InputStream in = new BufferedInputStream(connection.getInputStream(), BUFFER_SIZE);
             OutputStream out = new BufferedOutputStream(
                     Files.newOutputStream(
                         destination,
                         existingBytes == 0
                             ? new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE}
                             : new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND}
                     ),
                     BUFFER_SIZE
             )
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            long totalBytes = existingBytes;
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }
            out.flush();
            System.out.println("⬇️ Downloaded " + totalBytes + " bytes");
        } finally {
            connection.disconnect();
        }
    }
}