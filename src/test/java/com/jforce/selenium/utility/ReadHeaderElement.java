package com.jforce.selenium.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.jforce.selenium.actions.ElementActions;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@Component
public class ReadHeaderElement {
	
	
    @Autowired
    private ElementActions elementActions;
	
	
	/**
	 * Retrieves validated, non-empty table header names from the specified locator.
	 *
	 * @param locator The locator for header elements (e.g., TableOfContentElements.DATA_TABLE_HEADERS).
	 * @param description A description for logging clarity.
	 * @return List of non-empty header names.
	 */
    public List<String> getValidatedTableHeaders(By locator) {
        log.info("Retrieving data table header names");
        List<String> headers = new ArrayList<>();
        Set<String> seen = new HashSet<>();   // Track unique values

        int count = elementActions.getSize(locator);
        for (int i = 0; i < count; i++) {
            String text = elementActions.findElementsbyIndex(locator, i).trim();
            if (!text.isEmpty()) {
                if (!seen.add(text)) { // add() returns false if duplicate
                    log.error("Duplicate header found: {}", text);
                    throw new IllegalStateException("Duplicate header found: " + text);
                }
                log.debug("Header found: {}", text);
                headers.add(text);
            }
        }
        return headers;
    }

	
	
	/**
	 * Validates data table headers against expected values.
	 *
	 * @param locator The locator for header elements.
	 * @param expectedHeaders The expected list of headers to validate against.
	 * @param description A description for logging clarity.
	 * @param maxCompareCount Optional: max number of headers to compare (useful if the table may contain extra columns).
	 * @return true if expected headers match actual headers within comparison count; false otherwise.
	 */
	public boolean verifyHeadersWithExpected(By locator, List<String> expectedHeaders) {
	    log.info("Validating data table headers against expected values");

	    List<String> actual = getValidatedTableHeaders(locator);
	    List<String> expected = new ArrayList<>(expectedHeaders); // Defensive copy

	    int maxCompareCount = expected.size();
	    log.info("Actual headers count: {}, Expected headers count: {}", actual.size(), expected.size());

	    if (maxCompareCount > 0 && actual.size() > maxCompareCount) {
	        log.debug("Trimming actual headers from {} to {}", actual.size(), maxCompareCount);
	        actual = actual.subList(0, maxCompareCount);
	    }

	    boolean result = expected.equals(actual);
	    log.info("Header validation result: {}", result);

	    // Add TestNG assertion with clear, informative failure message
	    Assert.assertEquals(
	        actual,
	        expected,
	        String.format("Header validation failed! Expected: %s, but found: %s", expected, actual)
	    );
	    log.info("Header validation assertion passed: actual headers match expected headers.");
	    return result;
	}



}
