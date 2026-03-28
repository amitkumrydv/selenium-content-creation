package com.jforce.selenium.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jforce.selenium.common.Common;
import com.jforce.selenium.listeners.TestListener;
import com.jforce.selenium.pageObject.EpubPageobject;

@Listeners(TestListener.class)
public class EpubFileOpening extends Common {
	
	
	@Autowired private EpubPageobject epubPageobject;

	@Override
	protected String getRoleForTest() {
	
		return "CANVAS_ADMIN";
	}
	
	
	@Test 
	public void epubFileLinkOpening() {
		
		epubPageobject.epubFileOpeningValidation();
		
		
		
		
	}
	
	
	

}
