package com.jforce.selenium.interfaces;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public interface IUIElements {

	WebDriver getWebDriver();

	void sendKeys(By by, String keysToSend);

	void click(By locator, String elementName);
	
	void scrollByclick(By by);

	void openURL(String url);

	void searchAndClickByText(By by, String textForSearch);

	void clickNestedMenus(By by, String tagName, List<String> menuList);

	void searchAndClickTableByText(By by, String textForSearch, String value);

	String findElementsbyIndex(By by, int index);

	void searchAndClickRelativeLeftElement(By toLeftoOfBy, By withBy, String textForSearch);

	void clickRelativeLeftElement(By toLeftoOfBy, By withBy);
	
	int getSize(By by);
	
	public boolean isDisplayElement(By element);

	public void scrollByclick(By locator, String elementName);

	public void click(By locator);
	
	public List<String> getTableRowText(By by);
	
	public String getTextByLoadPageAndScroll(By locator);
	
	public void scrollByText(By locator);

	public String gettextOfElement(By locator);

	/** 
	 * Returns current browser URL after ensuring navigation completed.
	 */
	public String getCurrentUrl();

	/** 
	 * Returns the current page title after ensuring page load.
	 */
	public String getPageTitle();

	
	

}
