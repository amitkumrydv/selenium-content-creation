package com.jforce.selenium.pageObject;

import static com.jforce.selenium.constants.EndPointConstants.ENDPOINT_LTI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jforce.selenium.actions.ElementActions;
import com.jforce.selenium.actions.JavaScriptActions;
import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.common.CommonPageObject;
import com.jforce.selenium.elements.TableOfContentElements;
import com.jforce.selenium.utility.ReadHeaderElement;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SidebarNavigationPageObject extends CommonPageObject{
	
	
    @Autowired private ElementActions elementActions;
    @Autowired private ReadHeaderElement readHeaderElement;
    @Autowired private WaitActions waitActions;
    @Autowired private JavaScriptActions javaScriptActions;
    
    
    @Step("Click on the sidebar menu")
    public void clickOnMenu() {
    	elementActions.click(TableOfContentElements.MENU, "Menu");

    }
	
	

}
