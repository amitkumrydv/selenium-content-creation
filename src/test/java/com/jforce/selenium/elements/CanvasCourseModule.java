package com.jforce.selenium.elements;

import org.openqa.selenium.By;

public class CanvasCourseModule {
	
	
	
	public static final By  COLLAPSE_ALL   = By.xpath("//button[@id='expand_collapse_all' and text()='Collapse All']");
	public static final By  EXPAND_ALL   = By.xpath("//button[@id='expand_collapse_all' and text()='Expand All']");
	public static final By  EPUB_FILE   = By.xpath("//a[contains(text(), '.epub')]");
	public static final By  EPUB_FILE_OPENING   = By.xpath("//a[@id='open_url_button']");
	public static final By  COLLAPSE_EXPAND  = By.xpath("//button[@id=\"expand_collapse_all\"]");
	
	
	public static By  epubFilRead(int index) {
		
		final By  EPUB_FILE   = By.xpath("(//span[@class='item_name']//a[contains(@href,'.epub')])"+"[" +index +"]");
		
		return EPUB_FILE;
		
	}
	

	
	

}
