package com.jforce.selenium.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public interface IExplicitWait {
	public WebElement waitForElementToBeClickable(By by);
}
