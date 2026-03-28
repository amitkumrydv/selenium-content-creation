package com.jforce.selenium.testdata;

import java.util.List;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.pageObject.TableOfContentPageObject;

@Component
public class TabForDataTable {
	
	

    @Autowired private TableOfContentPageObject tableOfContentPageObject;
    @Autowired private WaitActions waitActions;


    
    public void navigateToFacultyReview() {
        tableOfContentPageObject.navigateToFacultyReview();
    }
	
    // ---------- Navigation Helpers ----------
    public void navigateToTutorialProduction() {
        tableOfContentPageObject.openAdminLtiDashboard();
        tableOfContentPageObject.clickOnMenu();
        tableOfContentPageObject.clickOnETutorialProduction();
    }
	
	
    // ---------- Common Verifier ----------
    public  void verifyHeadersForTab(Runnable tabClick, List<String> expectedHeaders, By locator) {
        navigateToTutorialProduction();
        waitActions.waitForPageLoad();
        if (tabClick != null) tabClick.run();
        tableOfContentPageObject.expectedFieldName(expectedHeaders, locator);
    }
}
