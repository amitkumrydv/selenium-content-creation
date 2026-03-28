package com.jforce.selenium.validations;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import com.adobe.epubcheck.api.EpubCheck;

public class EpubFileValidator {

    public static boolean validateEpub(String epubUrl) {
        File tempEpub = null;
        try {
            // Download EPUB
            tempEpub = File.createTempFile("epub_test_", ".epub");
            
            System.out.println("Temp file path " + tempEpub.getAbsolutePath());
            System.out.println("Temp file exist " + tempEpub.exists());
            System.out.println("Temp file length  " + tempEpub.length());
            
            
            
            URL url = new URL(epubUrl);
            HttpURLConnection connection = ( HttpURLConnection) url.openConnection();
            connection.setInstanceFollowRedirects(true);
            connection.connect();
            
            System.out.println("HTTP respons code: " + connection.getResponseCode());
            System.out.println("HTTP respons content type : " + connection.getContentType());
            System.out.println("HTTP respons content length : " + connection.getContentLength());
            
            FileUtils.copyInputStreamToFile(connection.getInputStream(), tempEpub);
            
            System.out.println("Temp file size after copy : "+ tempEpub.length());
            
         //   FileUtils.copyURLToFile(new URL(epubUrl), tempEpub);

            // EPUBCheck validation
            EpubCheck epubCheck = new EpubCheck(tempEpub);
            int resultCode = epubCheck.doValidate();

            // 0 = valid, >0 = invalid
            return resultCode == 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        } finally {
            if (tempEpub != null && tempEpub.exists()) {
                tempEpub.delete();
            }
        }
    }
}
