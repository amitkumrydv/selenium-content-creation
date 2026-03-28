package com.jforce.selenium.utility;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

import com.jforce.selenium.pageObject.EpubPageobject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class URLUtility {

    public static String getBaseUrl(String fullUrl) {
        try {
            URI uri = new URI(fullUrl);
            return uri.getScheme() + "://" + uri.getHost() + uri.getPath();
        } catch (Exception e) {
            return fullUrl;
        }
    }
    
    
    public static String getQueryParam(String fullUrl, String paramName) {
        try {
            URI uri = new URI(fullUrl);
            String query = uri.getQuery(); // url=xxxxx.epub

            if (query == null) return null;

            String[] params = query.split("&");
            for (String param : params) {
                String[] keyValue = param.split("=", 2);
                if (keyValue[0].equals(paramName)) {
                    return URLDecoder.decode(
                            keyValue[1],
                            StandardCharsets.UTF_8
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
