package com.jforce.selenium.pageObject;

import static com.jforce.selenium.constants.EndPointConstants.ENDPOINT_LTI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.jforce.selenium.actions.ElementActions;
import com.jforce.selenium.actions.JavaScriptActions;
import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.common.CommonPageObject;
import com.jforce.selenium.elements.TableOfContentElements;
import com.jforce.selenium.testdata.TutorialProductionTestData;
import com.jforce.selenium.utility.ReadHeaderElement;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TableOfContentPageObject extends CommonPageObject {

    @Autowired private ElementActions elementActions;
    @Autowired private ReadHeaderElement readHeaderElement;
    @Autowired private WaitActions waitActions;
    @Autowired private JavaScriptActions javaScriptActions;

    @Step("Open Admin LTI Dashboard")
    public void openAdminLtiDashboard() {
        log.info("Opening Admin LTI Dashboard");
        try {
            String url = seleniumProperties.getBaseUrl() + ENDPOINT_LTI;
            log.info("Opening Admin LTI Dashboard at URL: {}", url);
            iUIElements.openURL(url);
        } catch (Exception e) {
            Allure.addAttachment("Error", "Failed to open Admin LTI Dashboard");
            throw e;
        }
    }

    @Step("Navigate to filter icon and click on it")
    public void clickOnFilterIcon() {
    	elementActions.click(TableOfContentElements.FILTER_ICON, "Filter icon");

    }
    
    

    @Step("Click on the sidebar menu")
    public void clickOnMenu() {
    	elementActions.click(TableOfContentElements.MENU, "Menu");

    }

    // ====== Tab Clicks ======

    @Step("Click on E-Tutorial Production")
    public void clickOnETutorialProduction() {
    	
    	elementActions.scrollByclick(TableOfContentElements.E_TUTORIAL_PRODUCTION, "E tutorial production");
    }

    
    @Step("Click on Admin Approval tab")
    public void clickOnAdminApprovalTab() {
    	
        elementActions.click(TableOfContentElements.ADMIN_APPROVAL_TAB, "Admin Approval tab");
    }

    @Step("Click on Upload Raw tab")
    public void clickOnUploadRawTab() {
    	
        elementActions.click(TableOfContentElements.UPLOAD_RAW_TAB, "Upload raw video tab");

    }

    @Step("Click on Assign Editor tab")
    public void clickOnAssignEditorTab() {
    	
        elementActions.click(TableOfContentElements.ASSIGN_EDITOR_TAB, "Assign Editor");

    }

    @Step("Click on Add Video Version tab")
    public void clickOnAddVideoVersionTab() {

    	elementActions.click(TableOfContentElements.ADD_VIDEO_VERSION_TAB, " Add video version");

    }

    @Step("Click on Feedback Received tab")
    public void clickOnFeedbackReceivedTab() {
    	
    	elementActions.click(TableOfContentElements.FEEDBACK_RECEIVED_TAB, "Feedback Received tab");
    }

    @Step("Click on All Records tab")
    public void clickOnAllRecordTab() {
    	
    	javaScriptActions.click(TableOfContentElements.ALL_RECORDS_TAB);

    }

    @Step("Click on Shoot Scheduled tab")
    public void clickOnShootScheduledTab() {
    	
        elementActions.click(TableOfContentElements.SHOOT_SCHEDULED_TAB, "Shoot scheduled tab");
    }

    @Step("Click on Pending Review tab")
    public void clickOnPendingReviewTab() {
    	
        elementActions.click(TableOfContentElements.PENDING_REVIEW_TAB, "Pending review tab");

    }

    @Step("Click on Faculty Review tab")
    public void clickOnFacultyReview() {
    	
    	 elementActions.scrollByclick(TableOfContentElements.FACULTY_REVIEW_SIDEBAR);
    }

    @Step("Click on Create New Async Shoot")
    public void clickOnCreateNewAsyncShoot() {
    	
    	elementActions.click(TableOfContentElements.CREATE_NEW_ASYNC_SHOOT, "Create new async shoot");
    }

    @Step("Click on Close Icon")
    public void clickOnCloseIcon() {
    	
    	elementActions.click(TableOfContentElements.CLOSE_POPUP, "Close popup");
    }

    @Step("Click on Planning schedule")
    public void clickOnPlanningSchedulesTab() {
        
    	 elementActions.click(TableOfContentElements.PLANNING_SCHEDULES);
    }

    @Step("Click on Book slots")
    public void clickOnBookSlotsTab() {
    	
    	elementActions.click(TableOfContentElements.BOOK_SLOTS_TAB);

    }

  
    @Step("Click on Image Media")
    public void clickOnImageMediaTab() {
    	waitActions.waitForElementToBeClickable(TableOfContentElements.IMAGE_MEDIA_TAB);
    	log.info("Clicking on Image Media");
    	javaScriptActions.click(TableOfContentElements.IMAGE_MEDIA_TAB);
    }
    
    
    @Step("Click on Assign Image Media Uploader")
    public void clickOnAssignImageMediaUploaderTab() {
    	waitActions.waitForElementToBeClickable(TableOfContentElements.ASSIGN_IMAGE_MEDIA_UPLOAD_TAB);
    	log.info("Clicking on Assign Image Media Uploader");
    	javaScriptActions.click(TableOfContentElements.ASSIGN_IMAGE_MEDIA_UPLOAD_TAB);
    }
    
    
    @Step("Click on Upload transcript")
    public void clickOnUploadTranscriptTab() {
    	waitActions.waitForElementToBeClickable(TableOfContentElements.UPLOAD_TRANSCRIPT_TAB);
    	log.info("Clicking on Assign Image Media Uploader");
    	javaScriptActions.click(TableOfContentElements.UPLOAD_TRANSCRIPT_TAB);
    }
    
    
    

    // ====== UI Validations ======

    @Step("Verify column filter visibility")
    public void verifyColumnFilterVisible() {

        log.info("Verifying column filter visibility");
        Assert.assertTrue(elementActions.isDisplayElement(TableOfContentElements.COLUMN), "Column filter is not visible");

        try {
            log.info("Verifying column filter visibility");
            Assert.assertTrue(elementActions.isDisplayElement(TableOfContentElements.COLUMN), "Column filter is not visible");
        } catch (AssertionError e) {
            Allure.addAttachment("Error", "Column filter is not visible");
            throw e;
        }

    }

    @Step("Verify filter icon visibility")
    public void verifyFilterIconVisible() {

        log.info("Verifying filter icon visibility");
        Assert.assertTrue(elementActions.isDisplayElement(TableOfContentElements.COLUMN), "Filter icon is not visible");

        try {
            log.info("Verifying filter icon visibility");
            Assert.assertTrue(elementActions.isDisplayElement(TableOfContentElements.COLUMN), "Filter icon is not visible");
        } catch (AssertionError e) {
            Allure.addAttachment("Error", "Filter icon is not visible");
            throw e;
        }

    }

    @Step("Verify global search filter visibility")
    public void verifyGlobalSearchFilterVisible() {

        log.info("Verifying global search filter visibility");
        Assert.assertTrue(elementActions.isDisplayElement(TableOfContentElements.GLOBAL_SEARCH_FILTER), "Global search filter is not visible");

        try {
            log.info("Verifying global search filter visibility");
            Assert.assertTrue(elementActions.isDisplayElement(TableOfContentElements.GLOBAL_SEARCH_FILTER), "Global search filter is not visible");
        } catch (AssertionError e) {
            Allure.addAttachment("Error", "Global search filter is not visible");
            throw e;
        }

    }

    // ====== Header Validations ======

    @Step("Validate headers for Assign Editor")
    public void validateAssignEditorHeaders() {
        try {
            log.info("Validating headers for Assign Editor tab");
            readHeaderElement.verifyHeadersWithExpected(
                TableOfContentElements.DATA_TABLE_HEADERS,
                TutorialProductionTestData.EXPECTED_HEADERS_FOR_ASSIGN_EDITOR
            );
        } catch (Exception e) {
            Allure.addAttachment("Error", "Failed to validate Assign Editor headers");
            throw e;
        }
    }

    @Step("Validate form headers for Create New Async Shoot")
    public void validateCreateNewAsyncShootFormHeaders() {
        try {
            log.info("Validating form headers for Create New Async Shoot");
            readHeaderElement.verifyHeadersWithExpected(
                TableOfContentElements.CREATE_NEW_ASYNC_SHOOT,
                TutorialProductionTestData.EXPECTED_HEADERS_FOR_CREATE_NEW_ASYNC_SHOOT
            );
        } catch (Exception e) {
            Allure.addAttachment("Error", "Failed to validate Create New Async Shoot form headers");
            throw e;
        }
    }

    @Step("Validate table headers from locator")
    public void expectedFieldName(List<String> expectedHeaders, By locator) {
        try {
            log.info("Validating table headers at locator: {}", locator);
            List<String> actualHeaders = readTableHeader(locator);

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

            Assert.assertEquals(actual, expected, "Mismatch data .\nMissing: " + missing + "\nUnexpected: " + unexpected);
        } catch (Exception e) {
            Allure.addAttachment("Error", "Failed to validate table headers");
            throw e;
        }
    }

    @Step("Read table headers from the given locator")
    public List<String> readTableHeader(By locator) {
        try {
            log.debug("Reading table headers from locator: {}", locator);
            List<String> headers = new ArrayList<>();
            List<WebElement> elements = waitActions.waitForPresenceOfAllElements(locator);

            for (int i = 0; i < elements.size(); i++) {
                String text = elements.get(i).getText().trim().replaceAll("[^a-zA-Z0-9\\s.]", "");
                if (!text.isEmpty()) {
                    log.debug("Header [{}]: {}", i, text);
                    headers.add(text);
                }
            }

            log.info("Collected {} headers from locator", headers.size());
            return headers;
        } catch (Exception e) {
            Allure.addAttachment("Error", "Failed to read table headers");
            throw e;
        }
    }

    // ---------- Navigation Helpers ----------
    public void navigateToTutorialProduction() {
        try {
            log.info("Navigating to Tutorial Production section");
            openAdminLtiDashboard();
            clickOnMenu();
            clickOnETutorialProduction();
        } catch (Exception e) {
            Allure.addAttachment("Error", "Failed to navigate to Tutorial Production section");
            throw e;
        }
    }

    @Step("Navigate to Faculty Review section")
    public void navigateToFacultyReview() {
        try {
            log.info("Navigating to Faculty Review section");
            openAdminLtiDashboard();
            clickOnMenu();
            clickOnFacultyReview();
        } catch (Exception e) {
            Allure.addAttachment("Error", "Failed to navigate to Faculty Review section");
            throw e;
        }
    }

    // ---------- Common Verifier ----------
    @Step("Verify headers for given tab")
    public void verifyHeadersForTab(Runnable tabClick, List<String> expectedHeaders, By locator) {
        try {
            log.info("Verifying headers for tab using dynamic tab click and locator");
            navigateToTutorialProduction();
            waitActions.waitForPageLoad();
            if (tabClick != null) {
                log.debug("Invoking tab click");
                tabClick.run();
            }
            expectedFieldName(expectedHeaders, locator);
        } catch (Exception e) {
            Allure.addAttachment("Error", "Failed to verify headers for the given tab");
            throw e;
        }
    }
    
    
    
    public void validateAsyncShootForm() {
        log.info(" Validating field names in 'Create New Async Shoot' form...");
        navigateToTutorialProduction();
        waitActions.waitForPageLoad();
        clickOnCreateNewAsyncShoot();
    }
    
}
