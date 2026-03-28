package com.jforce.selenium.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UtilityClass {

	public void scrollHelper(WebDriver driver, WebDriverWait webDriverWait, ApplicationContext applicationContext,
			By by) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		((JavascriptExecutor) applicationContext.getBean(WebDriver.class))
				.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
	}

	public void scrollByClick(WebDriver driver, WebDriverWait webDriverWait, ApplicationContext applicationContext,
			By by) {
// Wait until the element is clickable
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));

		WebElement element = driver.findElement(by);

// Scroll the element into view
		((JavascriptExecutor) applicationContext.getBean(WebDriver.class))
				.executeScript("arguments[0].scrollIntoView(true);", element);

// Now click the element
		element.click();
	}

}
