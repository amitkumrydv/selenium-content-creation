package com.jforce.selenium.elements;

import org.openqa.selenium.By;

public class GlobleElements {
	
	
	public static final By SUBMIT_BUTTON= By.xpath("//button[text()='Submit']");
	public static final By CANCEL_BUTTON= By.xpath("//button[text()='Cancel']");
	public static final By ADD_SUBJECT_CODE_PAGE_TITLE= By.xpath("//div//h1[text()='Add Subject Code']");
	public static final By EXISTING_SUBJECT_CODE= By.xpath(
			                                   "//form//following::h2[normalize-space(.)='Existing Subject Codes']");
	
	

}
