package com.jforce.selenium.actions;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Advanced Wait Utility for Selenium Framework (Spring Boot + TestNG)
 * Centralizes explicit waits and page load handling.
 */
@Slf4j
@Component
public class WaitActions extends ActionsBaseClass {

    @Autowired
    WebDriverWait wait;

    private final int defaultTimeout = 15;

    /** Wait for an element to be visible. */
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /** Wait for an element to be visible (duplicate method removed). */
    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /** Wait for an element to be clickable by locator. */
    public WebElement waitForElementToBeClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    

    /** Wait until a list of elements are present in the DOM. */
    public List<WebElement> waitForPresenceOfAllElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    /** Wait until a list of elements are visible on the screen. */
    public List<WebElement> waitForVisibilityOfAllElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /** Wait until specific text appears inside an element. */
    public boolean waitUntilTextIsPresentInElement(WebElement element, String text) {
        try {
            return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    /** Wait until the current URL contains the given text. */
    public void waitForUrlContains(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    /** Wait for the URL to match exactly. */
    public void waitForUrlToBe(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

    /** Wait for the title to match. */
    public void waitForTitle(String title) {
        wait.until(ExpectedConditions.titleIs(title));
    }

    /** Wait for an element to disappear. */
    public boolean waitForInvisibility(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /** Wait for document.readyState to be 'complete'. */
    public void waitForPageLoad() {
    	
    	WebDriverWait pageWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	 try {
    	        pageWait.until(new ExpectedCondition<Boolean>() {
    	            @Override
    	            public Boolean apply(WebDriver driver) {
    	            	JavascriptExecutor jsExecutor = 
    	                        (JavascriptExecutor) applicationContext.getBean(WebDriver.class);
    	                // Must use 'return' in JS
    	                String readyState = (String) jsExecutor.executeScript("return document.readyState");
    	                return "complete".equals(readyState);
    	            }
    	        });
    	        
    	 }  catch (TimeoutException e) {
                  log.error("Error while page loading : {}", e);
    	            throw e;
    	        }
    	   
        }
    
    
    public void waitForTableDataLoad(By locater) {


        wait.until(ExpectedConditions.presenceOfElementLocated(locater));
    }

    /** Fluent wait with polling interval. */
    public WebElement fluentWaitForElement(WebElement element, int timeoutSeconds, int pollingMillis) {
        return new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(timeoutSeconds))
            .pollingEvery(Duration.ofMillis(pollingMillis))
            .ignoring(StaleElementReferenceException.class)
            .until(ExpectedConditions.visibilityOf(element));
    }

    /** Generic wait for a custom condition. */
    public <T> T waitForCondition(ExpectedCondition<T> condition) {
        return wait.until(condition);
    }

    /** Optional: Wait for URL containing text, returns boolean. */
    public boolean waitForUrlContainsSafe(String partialUrl, int timeoutSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.urlContains(partialUrl));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    /** Wait for at least one table row to be present. */
    public boolean waitForTableRows(By tableRowLocator) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver1.findElements(tableRowLocator).size() > 0);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    /** Sleep fallback — avoid unless necessary. */
    public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ignored) {
        }
    }
    
    
    public void waitForNewWindow(final Set<String> existingWindows) {

        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        localWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                int currentWindowCount = driver.getWindowHandles().size();
                int previousCount = existingWindows.size();
                return currentWindowCount > previousCount;
            }
        });
    }

}
