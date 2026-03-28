package com.jforce.selenium.pageObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.jforce.selenium.actions.ElementActions;
import com.jforce.selenium.actions.JavaScriptActions;
import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.elements.ADDSubjectCodeElements;
import com.jforce.selenium.elements.TableOfContentElements;
import com.jforce.selenium.testdata.ADDSubjectCodeTestData;
import com.jforce.selenium.testdata.TutorialProductionTestData;
import com.jforce.selenium.validations.ConstantElementVlidation;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ADDSubjectCodePageObject {
	
	
    @Autowired private ElementActions uiElements;
    @Autowired private TableOfContentPageObject tableOfContentPageObject;
    @Autowired private WaitActions waitActions;
    @Autowired private JavaScriptActions javaScriptActions;
    
    
    
    
    
    
    public void navigateToTutorialProduction() {
        try {
            log.info("Navigating to Tutorial Production section");
            tableOfContentPageObject.openAdminLtiDashboard();
            tableOfContentPageObject.clickOnMenu();
        } catch (Exception e) {
            Allure.addAttachment("Error", "Failed to navigate to Tutorial Production section");
            throw e;
        }
    }
    
    
    public void clickOnAddSubjectCode() {
    	
    	navigateToTutorialProduction();
    	
    	uiElements.scrollByclick(ADDSubjectCodeElements.ADD_SUBJECT_CODE_SIDBAR, "Add subject code");
    	
    	
    }
    
    
    
    
    

	
	@Step("take the element name from the UI")
	public List<String> getElementFromTheUI(By locater){
		try {
		List<String> elementList = new ArrayList<>();
		
		int count = uiElements.getSize(locater);
		
		for(int i=0; i<count; i++) {
			
			String text = uiElements.findElementsbyIndex(locater, i).trim();
			if(!text.isEmpty()) {
				
				log.info("Header text [{}]: {}", i, text);
				elementList.add(text);
				
			}
		}
		
		log.info("Final list of header: {}", elementList);
		
		return elementList;
		
       } catch (Exception e) {
        	
        Allure.addAttachment("Error", "Failed to read table headers");
        throw e;
     }

}
		
		
		  @Step("Validate contant name from locator")
		    public void expectedFieldName(List<String> expectedHeaders, By locator) {
		        try {
		            log.info("Validating table headers at locator: {}", locator);
		            List<String> actualHeaders = getElementFromTheUI(locator);

		            Set<String> expected = expectedHeaders.stream().map(String::trim).collect(Collectors.toSet());
		            Set<String> actual = actualHeaders.stream().map(String::trim).collect(Collectors.toSet());

		            Set<String> missing = new HashSet<>(expected);
		            missing.removeAll(actual);

		            Set<String> unexpected = new HashSet<>(actual);
		            unexpected.removeAll(expected);

		            if (!missing.isEmpty() || !unexpected.isEmpty()) {
		                log.warn("Header mismatch detected. Missing: {}, Unexpected: {}", missing, unexpected);
		            } else {
		                log.info("All headers match as expected.");
		            }

		            Assert.assertEquals(actual, expected, "Header mismatch.\nMissing: " + missing + "\nUnexpected: " + unexpected);
		        } catch (Exception e) {
		            Allure.addAttachment("Error", "Failed to validate table headers");
		            throw e;
		        }
		  
		  }


		public void validateAddSubjectCodeConstant() {
			        log.info(" Validating 'Add Video Version' table headers...");
			        clickOnAddSubjectCode();
			        waitActions.waitForTableRows(ADDSubjectCodeElements.ADD_SUBJECT_CODE_SIDBAR);
			        tableOfContentPageObject.expectedFieldName(
			        		ADDSubjectCodeTestData.ALL_ADD_SUBJECT_CONSTANT,
			        		ADDSubjectCodeElements.ADD_SUBJECT_CODE_FORM_CONSTANT
			        );
			        log.info(" Validate the all add subject constant.");
			    }
		        
		
		
  }
	
	
	
	
	
	
	


