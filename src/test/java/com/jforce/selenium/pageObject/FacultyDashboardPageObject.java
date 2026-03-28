package com.jforce.selenium.pageObject;

import static com.jforce.selenium.constants.EndPointConstants.ENDPOINT_LTI;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jforce.selenium.actions.ElementActions;
import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.common.CommonPageObject;
import com.jforce.selenium.elements.TableOfContentElements;
import com.jforce.selenium.utility.ReadHeaderElement;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FacultyDashboardPageObject extends CommonPageObject{
	
	
	
	 @Autowired
	 private ElementActions uiElements;
	 @Autowired 
	 private ElementActions elementActions;
	 @Autowired 
	 private ReadHeaderElement readHeaderElement;
	 @Autowired 
	 private WaitActions waitActions;

	 
	    @Step("open the admin lti Dashboard")
	    public void openAdminLtiDashboard() {
	    	
	        iUIElements.openURL(seleniumProperties.getBaseUrl() + ENDPOINT_LTI);
	    }
	    

		
		
		

}
