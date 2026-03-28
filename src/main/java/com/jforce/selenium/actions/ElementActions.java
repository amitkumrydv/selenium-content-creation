package com.jforce.selenium.actions;

import static com.jforce.selenium.constants.EndPointConstants.UIELEMENT_ERROR_TEXT;
import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jforce.selenium.interfaces.IUIElements;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class ElementActions extends ActionsBaseClass implements IUIElements {
	
    @Autowired private WaitActions waitActions;
    @Autowired private JavaScriptActions javaScriptActions;

    
    
	@Override
	public void click(By locator) {
        try {
            WebElement element =waitActions.waitForElementToBeClickable(locator);
            log.info("Clicking on {}", locator);
            element.click();
        } catch (Exception e) {
            log.error("Failed to click on {}", locator);
            Allure.addAttachment("Error", "Failed to click on " + locator);
            throw e;
        }
    }
	
	
	
	
	@Override
	public void click(By locator, String elementName) {
        try {
            waitActions.waitForElementToBeClickable(locator);
            log.info("Clicking on {}", elementName);
            driver.findElement(locator).click();
        } catch (Exception e) {
            log.error("Failed to click on {}", elementName);
            Allure.addAttachment("Error", "Failed to click on " + elementName);
            throw e;
        }
    }
	
	
	

	@Override
	public void sendKeys(By by, String keysToSend) {
		utilityClass.scrollHelper(driver, webDriverWait, applicationContext, by);
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(keysToSend);
		log.debug("Typed in text : {}", keysToSend);

	}

	@Override
	public void openURL(String url) {
		log.info("Loading {}", url);
		driver.get(url);

	}

	@Override
	public void clickNestedMenus(By by, String tagName, List<String> menuList) {

		utilityClass.scrollHelper(driver, webDriverWait, applicationContext, by);
		WebElement headerWebElement = driver.findElements(by).stream()
				.filter(element -> element.getText().toLowerCase().contains(menuList.get(0).toLowerCase())).findFirst()
				.orElseThrow(() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, by, menuList.get(0))));
		headerWebElement.click();
		log.debug("Found and clicked on Header Element with Text : {}", menuList.get(0));

		for (int i = 1; i < menuList.size(); i++) {
			String subMenuName = menuList.get(i);
			headerWebElement = headerWebElement.findElements(By.tagName(tagName)).stream()
					.filter(element -> element.getText().toLowerCase().contains(subMenuName.toLowerCase())).findFirst()
					.orElseThrow(() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, by, subMenuName)));
			headerWebElement.click();
			log.debug("Found and clicked on Sub Element with Text : {}", subMenuName);
		}
	}

	@Override
	public String findElementsbyIndex(By by, int index) {
		utilityClass.scrollHelper(driver, webDriverWait, applicationContext, by);
		return driver.findElements(by).get(index).getText();
	}

	@Override
	public void searchAndClickByText(By by, String textForSearch) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElements(by).stream()
				.filter(element -> element.getText().toLowerCase().contains(textForSearch.toLowerCase())).findFirst()
				.orElseThrow(() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, by, textForSearch))).click();

		log.debug("Found and clicked on Element with Text : {}", textForSearch);

	}

	@Override
	public void clickRelativeLeftElement(By toLeftoOfBy, By withBy) {
		utilityClass.scrollHelper(driver, webDriverWait, applicationContext, withBy);
		driver.findElement(RelativeLocator.with(withBy).toLeftOf(toLeftoOfBy)).click();
		log.debug("Clicked on Link..");

	}

	@Override
	public void searchAndClickRelativeLeftElement(By toLeftoOfBy, By withBy, String textForSearch) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(toLeftoOfBy));
		driver.findElement(RelativeLocator.with(withBy).toLeftOf(driver.findElements(toLeftoOfBy).stream()
				.filter(element -> element.getText().toLowerCase().contains(textForSearch.toLowerCase())).findFirst()
				.orElseThrow(
						() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, toLeftoOfBy, textForSearch)))))
				.click();

	}

	@Override
	public void searchAndClickTableByText(By by, String textForSearch, String value) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		WebElement webElement = driver.findElements(by).stream()
				.flatMap(row -> row.findElements(By.tagName("td")).stream())
				.filter(column -> column.getText().toLowerCase().contains(textForSearch.toLowerCase())).findFirst()
				.orElseThrow(() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, by, textForSearch)));
		driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(webElement)).sendKeys(value);

	}

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

	@Override
	public int getSize(By by) {
	    try {
	        List<WebElement> elements = driver.findElements(by);
	        return elements.size();
	    } catch (Exception e) {
	        System.err.println("Error in getSize for locator: " + by + " - " + e.getMessage());
	        return 0;
	    }
	}
	
	@Override
	public boolean isDisplayElement(By locator) {
	    try {
	    	waitActions.waitForVisibility(locator);
	        WebElement element = driver.findElement(locator);
	        return element.isDisplayed();
	    } catch (NoSuchElementException | StaleElementReferenceException e) {
	        return false;
	    }
	}

	@Override
	public void scrollByclick(By locator) {
		utilityClass.scrollByClick(driver, webDriverWait, applicationContext, locator);
        log.info("Clicking on {}", locator);
      }
	
	@Override
	public void scrollByText(By locator) {
		utilityClass.scrollHelper(driver, webDriverWait, applicationContext, locator);
		log.info("Clicking on {}", locator);
	}
	
	
	
	@Override
	public void scrollByclick(By locator, String elementName) {
		
		waitActions.waitForElementToBeClickable(locator);
		log.debug("Clicked on Locater..");
		 try {
			 scrollByclick(locator);
		
	    } catch (Exception e) {
	            log.error("Failed to click on {}", elementName);
	            Allure.addAttachment("Error", "Failed to click on " + elementName);
	            throw e;
	        }

	}
	
	
	@Override
	public List<String> getTableRowText(By by) {
	    List<String> texts = new ArrayList<>();
	    try {
	        List<WebElement> elements = driver.findElements(by);
	        for (WebElement element : elements) {
	            String text = element.getText().trim();
	            if (!text.isEmpty()) {
	                texts.add(text);
	            }
	        }
	    } catch (Exception e) {
	        System.err.println("Error in getTexts for locator: " + by + " - " + e.getMessage());
	    }
	    return texts;

	}
	
	/**
	 * Retrieves the visible text of a web element after ensuring it's visible and scrolling it into view.
	 *
	 * @param locator The By locator of the element.
	 * @return The trimmed text of the element, or an empty string if an error occurs.
	 */
	
	@Override
	public String getTextByLoadPageAndScroll(By locator) {
	    try {
	    	
	        // Scroll element into view (optional click scroll)
            javaScriptActions.scrollByWindow();
            
            waitActions.waitForPageLoad();
            
			WebElement element = driver.findElement(locator);
			
			waitActions.fluentWaitForElement(element, 20,200);

	        // Return trimmed text
	        return element.getText().trim();

	    } catch (NoSuchElementException | TimeoutException e) {
	        log.warn("Element not found or not visible for locator {}: {}", locator, e.getMessage());
	        Allure.addAttachment("Element Not Found", "Locator: " + locator);
	        return "";
	    } catch (Exception e) {
	        log.error("Error while getting text or scrolling for locator {}: {}", locator, e.getMessage(), e);
	        Allure.addAttachment("Error", "Locator: " + locator);
	        return "";
	    }
	}
	
	@Override
	public String gettextOfElement(By locator) {
		
		String text = "";
		
		try {
		waitActions.waitForElementToBeClickable(locator);
		WebElement element = driver.findElement(locator);
		
		
		
		text= element.getText().trim();
		log.info(text);
		

		
	 } catch (TimeoutException e) {
	        log.error("Timeout: Element not found within expected time: " + locator  +e.fillInStackTrace());
	        
	    } catch (NoSuchElementException e) {
	        log.error("Element not found: " + locator  +e.fillInStackTrace());
	        
	    } catch (StaleElementReferenceException e) {
	        log.error("Stale element detected, retrying once: " + locator +e.fillInStackTrace());
	    }
		return text;
		
	
	}
	
	
	/** 
	 * Returns the current page title after ensuring page load.
	 */
	@Override
	public String getPageTitle() {
	    try {
	        waitActions.waitForPageLoad();
	        String title = driver.getTitle();
	        log.info("Page Title: {}", title);
	        return title;
	    } catch (Exception e) {
	        log.error("Failed to get page title", e);
	        Allure.addAttachment("Error", "Unable to get Page Title");
	        return "";
	    }
	}

	/** 
	 * Returns current browser URL after ensuring navigation completed.
	 */
	@Override
	public String getCurrentUrl() {
	    try {
	        waitActions.waitForPageLoad();
	        String currentUrl = driver.getCurrentUrl();
	        log.info("Current URL: {}", currentUrl);
	        return currentUrl;
	    } catch (Exception e) {
	        log.error("Failed to get current URL", e);
	        Allure.addAttachment("Error", "Unable to get URL");
	        return "";
	    }
	}

	
	
	


}
