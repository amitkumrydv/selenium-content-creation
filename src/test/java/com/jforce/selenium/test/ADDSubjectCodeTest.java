package com.jforce.selenium.test;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jforce.selenium.common.Common;
import com.jforce.selenium.listeners.TestListener;
import com.jforce.selenium.pageObject.ADDSubjectCodePageObject;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;

@Epic("--")
@TmsLink("TMS-004")
@Listeners(TestListener.class)
public class ADDSubjectCodeTest extends Common {
	
	
	@Autowired ADDSubjectCodePageObject addSubjectCodePageObject;

	
    protected String getRoleForTest() {
        return "ADMIN";
    }
	
	
    
    @Test
    @DisplayName("Verify all field name")
    @Description("Checks that all field name of the page")
    public void compareAddSubjectConstant() {
    	
    	addSubjectCodePageObject.validateAddSubjectCodeConstant();
    	
    }
	
	
}
