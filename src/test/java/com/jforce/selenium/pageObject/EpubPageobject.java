package com.jforce.selenium.pageObject;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.asserts.SoftAssert;

import com.jforce.selenium.actions.ElementActions;
import com.jforce.selenium.actions.JavaScriptActions;
import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.common.CommonPageObject;
import com.jforce.selenium.elements.CanvasCourseModule;
import com.jforce.selenium.utility.EpubUrlStore;
import com.jforce.selenium.utility.URLUtility;
import com.jforce.selenium.validations.EpubFileValidator;
import com.jforce.selenium.validations.EpubReaderValidator;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Component
public class EpubPageobject extends CommonPageObject{
	
    @Autowired private ElementActions uiElements;
    @Autowired private TableOfContentPageObject tableOfContentPageObject;
    @Autowired private WaitActions waitActions;
    @Autowired private JavaScriptActions javaScriptActions;
    @Autowired private EpubUrlStore epubUrlStore;
    @Autowired private URLUtility uRLUtility;
    
    
  
	
	public void navigateToTheModule(String courseId) {

		try {
		
		String url = seleniumProperties.getBaseUrl() + "courses/"+courseId+"/modules";
        log.info("Opening Admin LTI Dashboard at URL: {}", url);
		
		      iUIElements.openURL(url);
		      log.info("Using url : {}",url );
		      
		  }  
		    catch (Exception e) {
             Allure.addAttachment("Error", "Failed to navigate ");
            throw e;
        }
		
	}
	
	
	public void navigateToEpub(int index) {
		log.info("Clicking on the EPUB");
		
		javaScriptActions.scrollByClick(CanvasCourseModule.epubFilRead(index));
	}
	
	
	public void navigateToEpubFileOpening() {
		
		uiElements.click(CanvasCourseModule.EPUB_FILE_OPENING);
		
	}
	
	
	public void clickOnCollapsButton() {
		
		javaScriptActions.scrollByClick(CanvasCourseModule.COLLAPSE_ALL);
	}
	
	public void clickOnExpandsButton() {
		
		javaScriptActions.scrollByClick(CanvasCourseModule.EXPAND_ALL);
	}

	
	public void expandAll() {
		
		String text =javaScriptActions.scrollByElementGetText(CanvasCourseModule.COLLAPSE_EXPAND);
		
		String expand="Expand all";
		
		if (!expand.equalsIgnoreCase(text)) {
		       log.info("Condition matched: Button shows 'Expand all'. Performing click...");
		       clickOnCollapsButton();
		       clickOnExpandsButton();
			
		}else if (expand.equalsIgnoreCase(text)) {
			
		       log.info("Condition matched: Button shows 'Expand all'. Performing click...");
		       clickOnExpandsButton();
			
		}
		
	}
	
	
	public void switchToNewTabAndReturn() {

	    try {
	        String originalWindow = driver.getWindowHandle();


	        for(String window: driver.getWindowHandles()) {
	        	
	        	if(!window.equals(originalWindow)) {
	        		
	        		driver.switchTo().window(window);
	        	}
	        }


	        // Ensure page loads completely before validation
	        waitActions.waitForPageLoad();

	        validateEpubPage();

	        driver.close(); // Close the new tab

	        // Switch back to main tab
	        driver.switchTo().window(originalWindow);

	    } catch (Exception ex) {
	        log.error("Window Handler Error: {}", ex.getMessage());
	        Allure.addAttachment("Window Handling Error", ex.getMessage());
	        throw ex;
	    }
	}



	
//	public void validateEpubPage() {
//
//	    SoftAssert soft = new SoftAssert();
//
//	    // Read current URL
//	    String fullUrl = uiElements.getCurrentUrl();
//	    log.info("Full EPUB page URL: " + fullUrl);
//
//	    // Extract base URL
//	    String baseUrl = uRLUtility.getBaseUrl(fullUrl);
//	    log.info("Base EPUB URL: " + baseUrl);
//
//	    // Expected base URL
//	    String expectedBaseUrl = "https://portal.bennettonline.com/service-request-app/reader";
//
//	    // Capture assertion result
//	    String assertionStatus;
//
//	    try {
//	        soft.assertEquals(baseUrl, expectedBaseUrl, "Base EPUB URL mismatch!");
//	        assertionStatus = "PASS";
//	    } catch (AssertionError e) {
//	        assertionStatus = "FAIL";
//	    }
//
//	    // Store URL + Assertion Status in Excel
//	    EpubUrlStore.appendUrl(
//	            "EPUB_URL.xlsx",
//	            "EPUB",
//	            fullUrl,
//	            assertionStatus
//	    );
//
//	    // Trigger all soft assertions
//	    soft.assertAll();
//	}

	
	
	public void validateEpubPage() {

	    SoftAssert soft = new SoftAssert();

	    String readerUrl = uiElements.getCurrentUrl();
	    String epubFileUrl = uRLUtility.getQueryParam(readerUrl, "url");

	    log.info("Reader URL: " + readerUrl);
	    log.info("EPUB File URL: " + epubFileUrl);

	    /* ===============================
	       PHASE 1 – EPUB FILE VALIDATION
	       =============================== */

	    boolean epubValid = EpubFileValidator.validateEpub(epubFileUrl);
	    soft.assertTrue(epubValid, "EPUB file is corrupted or invalid");

	    /* ===============================
	       PHASE 2 – UI VALIDATION
	       =============================== */

	    driver.get(readerUrl);
	    EpubReaderValidator readerValidator = new EpubReaderValidator(driver);

	    boolean readerLoaded = readerValidator.isReaderLoaded();
	    soft.assertTrue(readerLoaded, "EPUB reader failed to load");

	    boolean contentVisible = readerValidator.isContentVisible();
	    soft.assertTrue(contentVisible, "EPUB content not visible");

	    boolean navigationWorking = readerValidator.isNavigationWorking();
	    soft.assertTrue(navigationWorking, "EPUB page navigation failed");

	    /* ===============================
	       PHASE 3 – EXCEL REPORTING
	       =============================== */

	    EpubUrlStore.appendUrl(
	            "EPUB_URL.xlsx",
	            "EPUB",
	            readerUrl,
	            epubValid ? "PASS" : "FAIL",
	            readerLoaded ? "PASS" : "FAIL",
	            contentVisible ? "PASS" : "FAIL",
	            navigationWorking ? "PASS" : "FAIL"
	    );

	    soft.assertAll();
	}

	

	
	
	
	
	public synchronized  void epubFileOpeningValidation() {
		

		
		
		    ArrayList<String> ids = new ArrayList<>(Arrays.asList(
		    	"610","611","612","613","614","615","616","617","618","619","620",
			    "621","622","623","624","625","626","627","628","629","630","631",
			    "632","633","634","636","637","638","640","650","651","652","653"
			));
		    
		int courseId =ids.size();
		
		for(int i=0; i<=courseId; i++) {
			
			navigateToTheModule(ids.get(i));
			
			int totalEpub =uiElements.getSize(CanvasCourseModule.EPUB_FILE);
			
			for(int CountEpub=1; CountEpub<=totalEpub; CountEpub++) {
			
			expandAll();
			
			
			
			navigateToEpub(CountEpub);
			
			
			switchToNewTabAndReturn();

			
			navigateToTheModule(ids.get(i));
			
		}
			
			
			
		}
		    
		
	}
	
	
}
