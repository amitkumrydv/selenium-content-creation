package com.jforce.selenium.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jforce.selenium.interfaces.IJavaScriptActions;

import io.qameta.allure.Allure;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class JavaScriptActions extends ActionsBaseClass implements IJavaScriptActions {
	
	
	 @Autowired private WaitActions waitActions;
	 
//	    private JavascriptExecutor jsElement;
//
//	    @PostConstruct
//	    public void init() {
//	        // Cast WebDriver to JavascriptExecutor once
//	        this.jsElement = (JavascriptExecutor) driver;
//	    }
	

	@Override
	public void scrollIntoView(By by) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		log.debug("Test {}", driver.getTitle());
		((JavascriptExecutor) applicationContext.getBean(WebDriver.class))
				.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));

		driver.findElement(by).click();
		log.debug("Scrolled into View..");
	}
	
	
	@Override
	public List <String> getListByText(By by) {
		
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		List<String> list = new ArrayList<>();
		
		List<WebElement> element =driver.findElements(by);
        log.debug("Element Name {}", driver.getTitle());
        
        WebDriver driver = applicationContext.getBean(WebDriver.class);
        JavascriptExecutor jsElement = (JavascriptExecutor) driver;
        
        for(WebElement elementList : element) {
        jsElement.executeScript("arguments[0].scrollIntoView(true);", elementList);

         String text = elementList.getText().trim();
        
             if (!text.isEmpty()) {
        	     list.add(text);
            }
     } 
		log.debug("Scrolled into View..");
		
		return list;
	}

//	@Override
//	public void click(By by) {
//		WebElement element = driver.findElement(by);
//		((JavascriptExecutor) applicationContext.getBean(WebDriver.class))
//	    .executeScript("arguments[0].click();", element);
//
//		log.debug("Clicked on the locater..");
//
//	}
	
	
	@Override
	public void click(By locator) {
	    try {
	        WebElement element = waitActions.waitForElementToBeClickable(locator);
	        log.info("Clicking on {}", locator);
	        element.click();
	    } catch (ElementClickInterceptedException e) {
	        log.warn("Click intercepted. Retrying with JS Click.");
	        ((JavascriptExecutor) applicationContext.getBean(WebDriver.class))
	        .executeScript("arguments[0].click();", driver.findElement(locator));
	    
	    } catch (Exception e) {
	        log.error("Failed to click on {}", locator, e);
	      //  takeScreenshot("ClickError_" + locator);
	        throw e;
	    }
	}

	
	
	@Override
	public void click(By locator, String elementName) {
		try {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) applicationContext.getBean(WebDriver.class))
	    .executeScript("arguments[0].click();", element);

		log.debug("Clicked on the locater..");
		
		} catch (Exception e) {
            log.error("Failed to click on {}", elementName);
            Allure.addAttachment("Error", "Failed to click on " + elementName);
            throw new RuntimeException("Failed to click on " + elementName, e);
        }

	}
	
	
	
	
	
	@Override
	public boolean findLocationAndClick(By locator) {
	    WebElement target = driver.findElement(locator);
	    Point point = target.getLocation();
	    WebDriver driver = applicationContext.getBean(WebDriver.class);
	    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	    WebElement topElement = (WebElement) jsExecutor
	                    .executeScript("return document.elementFromPoint(arguments[0], arguments[1]);",
	                     point.getX() + 1, point.getY() + 1); // +1 offset avoids borders
	    return target.equals(topElement);
	}
	
	
	@Override
	public void scrollByClick(By by) {
		try {
		        WebElement element =webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		        log.debug("Test {}", driver.getTitle());
		        ((JavascriptExecutor) applicationContext.getBean(WebDriver.class))
				            .executeScript("arguments[0].scrollIntoView({block : 'center'});", driver.findElement(by));

		      log.debug("Scrolled into View..");
		      Thread.sleep(2000);
		      element.click();
		      log.debug("Clicked on element: {}", by);
		
	  } catch (Exception e) {
	        log.error("Error while scrolling and clicking on element {}: {}", by, e.getMessage());
	         e.fillInStackTrace();
	    }
	}
	
	
	@Override
	public void scrollByWindow() {

		((JavascriptExecutor) applicationContext.getBean(WebDriver.class))
		.executeScript("window.scrollBy(0,300)");

		log.debug("Hard scrolled");
	}
	
	
	@Override
	public void scrollByWindowRightSide() {

		((JavascriptExecutor) applicationContext.getBean(WebDriver.class))
		.executeScript("window.scrollBy(300,0)");

		log.debug("Hard scrolled");
	}
	
	
	
	@Override
	public void clickOnLatestElementAndSwithWindow(By locator) {
		
		  String currentWindow = driver.getWindowHandle();
		try {
			waitActions.waitForElementToBeClickable(locator);
			
			List<WebElement> links = driver.findElements(locator);
			

		    if (links.isEmpty()) {
		        throw new NoSuchElementException("No video version links found on page.");
		    }
		    
		    WebElement latestLink = links.get(links.size() - 1);
		    ((JavascriptExecutor) applicationContext.getBean(WebDriver.class))
		                         .executeScript("arguments[0].scrollIntoView({block:'center'});", latestLink);
			
			log.info("Clicking on {}", locator);
			latestLink.click();
			
			  for (String windowHandle : driver.getWindowHandles()) {
		            if (!windowHandle.equals(currentWindow)) {
		                driver.switchTo().window(windowHandle);
		                break;
		            }
			  }
			

		        log.info("Switched to new tab: {} ", driver.getTitle());

		} catch (Exception e) {
			log.error("Failed to click on {}", locator);
			Allure.addAttachment("Error", "Failed to click on " + locator);
			throw e;
		}
	}
	
	
	
	
	/**
     * Get an element's attribute value using JavaScriptExecutor.
     *
     * @param driver    WebDriver instance
     * @param locator   Locator (By.id, By.xpath, By.cssSelector, etc.)
     * @param attribute Attribute name (e.g. "value", "innerText", "href")
     * @return The attribute value, or null if not found
     */
	@Override
    public  String getAttributeUsingJS(By locator, String attribute) {

        WebElement element = driver.findElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object result = js.executeScript(
            "return arguments[0].getAttribute(arguments[1]);",
            element, attribute
        );

        return result != null ? result.toString().trim() : null;
    }

	@Override
	public void scrollByElement(By locator) {
		
		WebElement element= waitActions.waitForVisibility(locator);
		
		((JavascriptExecutor) applicationContext.getBean(WebDriver.class))
        .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
	}
	
	
	@Override
	public String  scrollByElementGetText(By locator) {
		
		WebElement element= waitActions.waitForVisibility(locator);
		
		((JavascriptExecutor) applicationContext.getBean(WebDriver.class))
        .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
		
		String text =element.getText();
		
		return text;
	}

	
}
