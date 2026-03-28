package com.jforce.selenium.validations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.jforce.selenium.actions.ElementActions;
import com.jforce.selenium.actions.JavaScriptActions;
import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.pageObject.TableOfContentPageObject;
import com.jforce.selenium.utility.ReadHeaderElement;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class ConstantElementVlidation {
	
	
    @Autowired private ElementActions elementActions;
    @Autowired private ReadHeaderElement readHeaderElement;
    @Autowired private WaitActions waitActions;
    @Autowired private JavaScriptActions javaScriptActions;
	
	
	
	 @Step("Read contant from the given locator")
	    public List<String> readTableHeader(By locator) {
	        try {
	            log.debug("Reading table headers from locator: {}", locator);
	            List<String> headers = new ArrayList<>();
	            List<WebElement> elements = waitActions.waitForPresenceOfAllElements(locator);

	            for (int i = 0; i < elements.size(); i++) {
	                String text = elements.get(i).getText().trim().replaceAll("[^a-zA-Z0-9\\s.]", "");
	                if (!text.isEmpty()) {
	                    log.debug("Header [{}]: {}", i, text);
	                    headers.add(text);
	                }
	            }

	            log.info("Collected {} headers from locator", headers.size());
	            return headers;
	        } catch (Exception e) {
	            Allure.addAttachment("Error", "Failed to read table headers");
	            throw e;
	        }
	    }
	
	
    @Step("Validate contant name from locator")
    public void expectedFieldName(List<String> expectedHeaders, By locator) {
        try {
            log.info("Validating table headers at locator: {}", locator);
            List<String> actualHeaders = readTableHeader(locator);

            Set<String> expected = expectedHeaders.stream().map(String::trim).collect(Collectors.toSet());
            Set<String> actual = actualHeaders.stream().map(String::trim).collect(Collectors.toSet());

            Set<String> missing = new HashSet<>(expected);
            missing.removeAll(actual);

            Set<String> unexpected = new HashSet<>(actual);
            unexpected.removeAll(expected);

            if (!missing.isEmpty() || !unexpected.isEmpty()) {
                log.warn("Header mismatch detected. Missing: {}, Unexpected: {}", missing, unexpected);
            } else {
                log.info("All headers match as expected.");
            }

            Assert.assertEquals(actual, expected, "Header mismatch.\nMissing: " + missing + "\nUnexpected: " + unexpected);
        } catch (Exception e) {
            Allure.addAttachment("Error", "Failed to validate table headers");
            throw e;
        }
    }

}
