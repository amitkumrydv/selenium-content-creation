package com.jforce.selenium.test;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jforce.selenium.common.Common;
import com.jforce.selenium.listeners.TestListener;
import com.jforce.selenium.pageObject.AdminDashboardPageObject;
import com.jforce.selenium.validations.TanStackTableConstantValidation;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

@Epic("TOC:PEJ-255")
@TmsLink("TMS-004")
@Listeners(TestListener.class)
public class AdminTutorialProduction extends Common {

    @Autowired
    private TanStackTableConstantValidation validations;
    @Autowired
    private AdminDashboardPageObject adminDashboardPageObject;

    protected String getRoleForTest() {
        return "ADMIN";
    }
    
    
    

    @Test
    @DisplayName("Verify Planning Schedule table headers")
    @Description("Checks that all expected columns in Planning Schedule table are visible and in correct order.")
    public void verifyPlanningScheduleTableHeaders() {
        validations.validatePlanningScheduleHeaders();
    }
    
    
    @Test
    @DisplayName("Verify Upload Raw Video table headers")
    @Description("Ensures Upload Raw Video table contains the correct headers.")
    public void verifyUploadRawVideoTableHeaders() {
        validations.validateUploadRawVideoHeaders();
    }
    
    
    @Test
    @DisplayName("Verify Assign Editor table headers")
    @Description("Validates that Assign Editor table has proper column names.")
    public void verifyAssignEditorTableHeaders() {
        validations.validateAssignEditorHeaders();
    }
    
    
    @Test
    @DisplayName("Verify Add Video Version table headers")
    @Description("Checks that Add Video Version table contains correct header labels.")
    public void verifyAddVideoVersionTableHeaders() {
        validations.validateAddVideoVersionHeaders();
    }
    
    
    @Test
    @DisplayName("Verify Admin Approval table headers")
    @Description("Checks that Admin Approval table displays correct header names.")
    public void verifyAdminApprovalTableHeaders() {
        validations.validateAdminApprovalHeaders();
    }
    
    
    @Test
    @DisplayName("Verify Feedback Received table headers")
    @Description("Ensures Feedback Received table shows correct column headers.")
    public void verifyFeedbackReceivedTableHeaders() {
        validations.validateFeedbackReceivedHeaders();
    }
    


    @Test
    @DisplayName("Verify Image Media tab headers")
    @Description("Checks that all expected headers in the Image Media tab are displayed correctly and in the correct order.")
    public void verifyImageMediaHeaders() {
        validations.validateImageMediaHeaders();
    }

    @Test
    @DisplayName("Verify Assign Image Media Uploader tab headers")
    @Description("Checks that all expected headers in the Assign Image Media Uploader tab are displayed correctly and in the correct order.")
    public void verifyAssignImageMediaUploaderHeaders() {
        validations.validateAssignImageMediaUploaderHeaders();
    }
    
    
    @Test
    @DisplayName("Verify Upload transcript tab headers")
    @Description("Checks that all expected headers in theUpload transcript tab are displayed correctly and in the correct order.")
    public void verifyUploadTranscriptHeaders() {
    	validations.validateUploadeTranscriptHeaders();
    }
   

    
    @Test
    @DisplayName("Verify All Record table headers for Admin")
    @Description("Validates all records table headers for Admin role.")
    public void verifyAllRecordHeader() {
        validations.validateAllRecordHeadersAdmin();
    }
    
    
    @Test(testName = "Verify 'Booking Slots' table headers in Faculty Review")
    @Story("Booking Slots Table")
    @Description("Verify that the 'Booking Slots' tab in Faculty Review has the correct table headers.")
    public void verifyBookSlotsTableHeaders() {
    	validations.validateBookingSlotsHeaders();
    }

    @Test(testName = "Verify 'Shoot Scheduled' table headers in Faculty Review")
    @Story("Shoot Scheduled Tab")
    @Description("Verify that the 'Shoot Scheduled' tab in Faculty Review has the correct table headers.")
    public void verifyShootScheduledTableHeaders() {
    	validations.validateShootScheduledHeaders();
    }

    @Test(testName = "Verify 'Pending Review' table headers in Faculty Review")
    @Story("Pending Review Tab")
    @Description("Verify that the 'Pending Review' tab in Faculty Review has the correct table headers.")
    public void verifyPendingReviewTableHeaders() {
    	validations.validatePendingReviewHeaders();
    }

    @Test(testName = "Verify 'All Records' table headers for Faculty in Faculty Review")
    @Story("All Records Tab")
    @Description("Verify that the 'All Records' tab in Faculty Review has the correct table headers for faculty.")
    public void verifyFacultyAllRecordTableHeaders() {
    	validations.validateAllRecordsFacultyHeaders();
    }
    
    
    
    
    // Filter
    
    @Test(testName = "Verify 'Filter title Planning Schedules' table headers for Faculty in Faculty Review")
    @Description("Validate that the 'All Records' tab in Faculty Review displays the correct filter titles (table headers) for Faculty users.")
    public void verifyPlanningScheduleleFilterHeaders() {
        validations.validatePlanningScheduleFilterTitle();
    }
    

    @Test(testName = "Verify 'Filter title For Upload Raw Video' table headers")
    @Description("Validate that the 'Upload Raw Video' tab displays the correct filter titles (table headers) for Admin.")
    public void verifyUploadRawVideoTableHeadersFilter() {
        validations.validateUploadRawVideoFilterTitle();
    }

    @Test(testName = "Verify 'Filter title For Assign Editor' table headers")
    @Description("Validate that the 'Assign Editor' tab displays the correct filter titles (table headers) for Admin.")
    public void verifyAssignEditorTableHeadersFilter() {
        validations.validateAssignEditorFilterTitle();
    }

    @Test(testName = "Verify 'Filter title For Add Video Version' table headers")
    @Description("Validate that the 'Add Video Version' tab displays the correct filter titles (table headers) for Admin.")
    public void verifyAddVideoVersionTableHeadersFilter() {
        validations.validateAddVideoVersionFilterTitle();
    }

    @Test(testName = "Verify 'Filter title For Admin Approval' table headers")
    @Description("Validate that the 'Admin Approval' tab displays the correct filter titles (table headers) for Admin.")
    public void verifyAdminApprovalTableHeadersFilter() {
        validations.validateAdminApprovalFilterTitle();
    }

    @Test(testName = "Verify 'Filter title For Feedback Received' table headers")
    @Description("Validate that the 'Feedback Received' tab displays the correct filter titles (table headers) for Admin.")
    public void verifyFeedbackReceivedTableHeadersFilter() {
        validations.validateFeedbackReceivedFilterTitle();
    }

    @Test(testName = "Verify 'Filter title For Image Media' table headers")
    @Description("Validate that the 'Image Media' tab displays the correct filter titles (table headers) for Admin.")
    public void verifyImageMediaTableHeadersFilter() {
        validations.validateImageMediaFilterTitle();
    }

    @Test(testName = "Verify 'Filter title For Assign Image Media Uploader' table headers")
    @Description("Validate that the 'Assign Image Media Uploader' tab displays the correct filter titles (table headers) for Admin.")
    public void verifyAssignImageMediaUploaderTableHeadersFilter() {
        validations.validateAssignImageMediaUploderFilterTitle();
    }

    @Test(testName = "Verify 'Filter title For Upload Transcript' table headers")
    @Description("Validate that the 'Upload Transcript' tab displays the correct filter titles (table headers) for Admin.")
    public void verifyUploadTranscriptTableHeadersFilter() {
        validations.validateUploadTranscriptFilterTitle();
    }

    
    @Test(testName = "Verify 'Filter title For  All Records' table headers ")
    @Description("Validate that the 'All Records' tab displays the correct filter titles (table headers) for Admin.")
    public void verifyAllRecordTableHeadersFilter() {
    	validations.validateAllRecoredFilterTitle();
    }
    
    
    
    
    @Test
    @DisplayName("Verify Async Shoot field names")
    @Description("Checks that all Async Shoot field names are correct and match the requirements.")
    public void verifyAsyncShootFieldName() {
        validations.validateAsyncShootFieldNames();
    }
    

    @Test
    @DisplayName("Async shoot subject drop down list")
    public void verifySubjectListInDrodown() {
           adminDashboardPageObject.enterTheSubjectDropDown();
    	
    }
    @Test(dependsOnMethods = "verifySubjectListInDrodown")
    @DisplayName("List of acad coordinator validation")
    public void verifyAcadCoordinatorDrodown() {
    	adminDashboardPageObject.listOfAcadCoordinaterInDropDown();
    	
    }
    @Test(dependsOnMethods = "verifyAcadCoordinatorDrodown")
    @DisplayName("List of Faculty validation")
    public void verifyFacultyDrodown() {
    	adminDashboardPageObject.validateTheFacultyList();
    	
    }
    
    
  
    
//    @Test(testName = "Verify video content ")
//    @Description("Validate the text data from the inside video")
//    public void verifyVideoContent() throws Exception {
//    	validations.validateVideoContent();
//    }
    
}
