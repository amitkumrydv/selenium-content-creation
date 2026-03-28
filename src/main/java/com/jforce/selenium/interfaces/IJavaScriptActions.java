package com.jforce.selenium.interfaces;

import java.util.List;

import org.openqa.selenium.By;


public interface IJavaScriptActions {

	public void scrollIntoView(By by);

	public void click(By by);

	public boolean findLocationAndClick(By locator);

	public void click(By locator, String elementName);
	
	public void scrollByClick(By by);
	
	public List <String> getListByText(By by) ;
	
	public void scrollByWindow();
	
	public void scrollByWindowRightSide();
	
	public void clickOnLatestElementAndSwithWindow(By locator);
	
	public  String getAttributeUsingJS(By locator, String attribute);
	  
	public void scrollByElement(By element);

	public String scrollByElementGetText(By locator);

}
