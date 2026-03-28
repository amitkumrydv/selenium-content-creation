package com.jforce.selenium.config;

import java.util.Base64;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jforce.selenium.actions.ActionsBaseClass;

import lombok.extern.slf4j.Slf4j;

@Scope("driverscope")
@Slf4j
@Component
public class AuthrizationToken extends ActionsBaseClass{
	
	@Autowired
	private WebDriver driver;
	
	public String getAccessToken() throws JSONException {
		   
		  if (driver == null) {
		        log.error("WebDriver is not initialized.");
		        return null;
		    }
		  
		  if (!(driver instanceof JavascriptExecutor)) {
		        log.error("WebDriver does not support JavaScript execution.");
		        return null;
		    }
		
		String tokenKey = seleniumProperties.getOid_token_key();
		
        // 1. Read token from localStorage
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String tokenJsonStr = (String) js.executeScript(
    	   "return window.localStorage.getItem('" + tokenKey + "');"
        );

        if (tokenJsonStr == null) {
            log.warn("Token not found in localStorage for key: {}", tokenKey);
            return null;
        }

        // 2. Parse the JSON and extract id_token
        JSONObject tokenJson = new JSONObject(tokenJsonStr);
        String idToken = tokenJson.getString("id_token");

        log.info("Extracted id_token: {}", idToken);

        // 3. Decode the JWT payload
        String[] jwtParts = idToken.split("\\.");
        if (jwtParts.length != 3) {
            log.error("Invalid JWT format for token: {}", idToken);
            return null;
        }

        String payloadJson = new String(Base64.getUrlDecoder().decode(jwtParts[1]));
        JSONObject payload = new JSONObject(payloadJson);

        // 4. Check token expiry
        long exp = payload.getLong("exp"); // Expiry time in seconds
        long currentTime = System.currentTimeMillis() / 1000;

        if (currentTime >= exp) {
            log.warn("Token is expired. Expiry: {}, Current: {}", exp, currentTime);
            return null;
        } else {
            long secondsRemaining = exp - currentTime;
            log.info("Token is valid. Time remaining: {} seconds.", secondsRemaining);
            return idToken;
        }
    }
	
	
	public void setAccessToken(String accessToken) {
		
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript(
		        String.format("window.localStorage.setItem('id_token', '%s');", accessToken)
		    );

		    driver.navigate().refresh(); // or go to /dashboard
	}
	
	
	
	
	
}
