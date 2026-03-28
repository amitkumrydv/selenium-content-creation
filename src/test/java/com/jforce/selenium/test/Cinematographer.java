package com.jforce.selenium.test;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.common.Common;
import com.jforce.selenium.elements.TableOfContentElements;
import com.jforce.selenium.listeners.TestListener;
import com.jforce.selenium.pageObject.TableOfContentPageObject;
import com.jforce.selenium.service.UserService;
import com.jforce.selenium.testdata.TutorialProductionTestData;
import com.jforce.selenium.validations.TanStackTableConstantValidation;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;

@Epic("TOC:PEJ-255")
@TmsLink("TMS-004")
@Listeners(TestListener.class)
public class Cinematographer extends Common {


	 @Autowired private TanStackTableConstantValidation validations;
	   
    @Override
    protected String getRoleForTest() {
        return "CINEMATOGRAPHER";
    }


    @Test(testName = "Verify 'Upload Raw Video' table headers in Tutorial Production")
    public void verifyUploadRawVideoTableHeaders() {
        validations.validateUploadRawVideoHeaders();
    }

    @Test(testName = "Verify 'All Records' table headers for Cinematographer in Tutorial Production")
    public void verifyAllRecordHeaderCinematographer() {
        validations.validateAllRecordHeadersCinematographer();
    }
    

}
