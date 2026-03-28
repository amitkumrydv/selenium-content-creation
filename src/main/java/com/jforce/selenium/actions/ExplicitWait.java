package com.jforce.selenium.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

import com.jforce.selenium.interfaces.IExplicitWait;

@Component
public class ExplicitWait extends ActionsBaseClass implements IExplicitWait {

	@Override
	public WebElement waitForElementToBeClickable(By by) {
		return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
	}

}
