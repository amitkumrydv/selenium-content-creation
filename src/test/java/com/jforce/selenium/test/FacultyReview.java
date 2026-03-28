package com.jforce.selenium.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.common.Common;
import com.jforce.selenium.elements.TableOfContentElements;
import com.jforce.selenium.listeners.TestListener;
import com.jforce.selenium.pageObject.TableOfContentPageObject;
import com.jforce.selenium.testdata.TutorialProductionTestData;
import com.jforce.selenium.validations.TanStackTableConstantValidation;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

@Epic("TOC:PEJ-255")
@TmsLink("TMS-004")
@Listeners(TestListener.class)
public class FacultyReview extends Common {

    @Autowired private TanStackTableConstantValidation facultyReviewValidations;
    @Autowired private WaitActions waitActions;

    @Override
    protected String getRoleForTest() {
        return "FACULTY";
    }

    @Test(testName = "Verify 'Booking Slots' table headers in Faculty Review")
    @Story("Booking Slots Table")
    @Description("Verify that the 'Booking Slots' tab in Faculty Review has the correct table headers.")
    public void verifyFacultyBookSlotsTableHeaders() {
        facultyReviewValidations.validateBookingSlotsHeaders();
    }

    @Test(testName = "Verify 'Shoot Scheduled' table headers in Faculty Review")
    @Description("Verify that the 'Shoot Scheduled' tab in Faculty Review has the correct table headers.")
    public void verifyFacultyShootScheduledTableHeaders() {
        facultyReviewValidations.validateShootScheduledHeaders();
    }

    @Test(testName = "Verify 'Pending Review' table headers in Faculty Review")
    @Description("Verify that the 'Pending Review' tab in Faculty Review has the correct table headers.")
    public void verifyFacultyPendingReviewTableHeaders() {
        facultyReviewValidations.validatePendingReviewHeaders();
    }

    @Test(testName = "Verify 'All Records' table headers for Faculty in Faculty Review")
    @Description("Verify that the 'All Records' tab in Faculty Review has the correct table headers for faculty.")
    public void verifyFacultyAllRecordTableHeaders() {
        facultyReviewValidations.validateAllRecordsFacultyHeaders();
    }
    
    
    @Test(testName = "Verify 'Book slot'  filter input field name")
    @Description("Verify that the 'book slot filters' tab in Faculty Review has the correct table headers for faculty.")
    public void verifyFacultyBookSlotFiltersTitle() {
    	facultyReviewValidations.validateBookSlotFilterTitle();
    }
    
    
    @Test(testName = "Verify 'shoot scheduled' filter input field name")
    @Description("Verify that the 'shoot scheduled filters' tab in Faculty Review has the correct table headers for faculty.")
    public void verifyFacultyShootScheduledFiltersTitle() {
    	facultyReviewValidations.validateFacultyShootScheduleFilterTitle();
    }
    
    @Test(testName = "Verify 'Pending Review' filter input field name")
    @Description("Verify that the 'Pending Review  filters' tab in Faculty Review has the correct table headers for faculty.")
    public void verifyFacultyPendingReviewFiltersTitle() {
    	facultyReviewValidations.validatePendingReviewFilterTitle();
    }
    
    @Test(testName = "Verify 'Faculty all records' filter input field name")
    @Description("Verify that the 'all records  filters' tab in Faculty Review has the correct table headers for faculty.")
    public void verifyFacultyAllRecordFiltersTitle() {
    	facultyReviewValidations.validateFacultyAllRecordFilterTitle();
    }
    
    
    
    
    
    
    
}

