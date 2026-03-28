package com.jforce.selenium.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.config.FFmpegConfig;
import com.jforce.selenium.config.VideoTextValidator;
import com.jforce.selenium.elements.TableOfContentElements;
import com.jforce.selenium.pageObject.AdminDashboardPageObject;
import com.jforce.selenium.pageObject.TableOfContentPageObject;
import com.jforce.selenium.testdata.TutorialProductionTestData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TanStackTableConstantValidation {
	
	

	    @Autowired private TableOfContentPageObject tableOfContentPageObject;
	    @Autowired private WaitActions waitActions;
	    @Autowired private AdminDashboardPageObject adminDashboardPageObject;

	    public void validatePlanningScheduleHeaders() {
	        log.info(" Validating 'Planning Schedules' table headers...");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnPlanningSchedulesTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_PLANING,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'Planning Schedules' table headers.");
	    }
	    
  
	    public void validateAdminApprovalHeaders() {
	        log.info(" Validating 'Admin Approval' table headers...");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnAdminApprovalTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_ADMIN_APPROVAL,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'Admin Approval' table headers.");
	    }

	    public void validateUploadRawVideoHeaders() {
	        log.info(" Validating 'Upload Raw Video' table headers...");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnUploadRawTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_RAW_VIDEO_UPLOAD,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'Upload Raw Video' table headers.");
	    }

	    public void validateAssignEditorHeaders() {
	        log.info(" Validating 'Assign Editor' table headers...");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnAssignEditorTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_ASSIGN_EDITOR,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'Assign Editor' table headers.");
	    }

	    public void validateAddVideoVersionHeaders() {
	        log.info(" Validating 'Add Video Version' table headers...");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnAddVideoVersionTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_ADD_VIDEO_VERSION,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'Add Video Version' table headers.");
	    }

	    public void validateFeedbackReceivedHeaders() {
	        log.info(" Validating 'Feedback Received' table headers...");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnFeedbackReceivedTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_FEEDBACK_RECEIVED,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'Feedback Received' table headers.");
	    }

	    public void validateAllRecordHeadersAdmin() {
	        log.info(" Validating 'All Records' table headers for Admin...");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnAllRecordTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_EDITORTEAM_LEAD_ALL_RECORDS,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'All Records' table headers for Admin.");
	    }
	    
	    
	    public void validateAllRecordHeadersEditor() {
	        log.info(" Validating 'All Records' table headers for Editor...");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnAllRecordTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_EDITOR_ALL_RECORDS,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'All Records' table headers for Editor.");
	    }
	    
	    
	    public void validateAllRecordHeadersCinematographer() {
	        log.info(" Validating 'All Records' table headers for Cinematographer...");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnAllRecordTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_CINEMATOGRAPHER_ALL_RECORDS,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'All Records' table headers for Cinematographer.");
	    }
	    
	    
	    
	    

	    public void validateAsyncShootFieldNames() {
	        log.info(" Validating field names in 'Create New Async Shoot' form...");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        waitActions.waitForPageLoad();
	        tableOfContentPageObject.clickOnCreateNewAsyncShoot();
	        waitActions.waitForVisibility(TableOfContentElements.CREATE_ASYNC_SHOOT_FIELD_NAME);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_CREATE_NEW_ASYNC_SHOOT,
	                TableOfContentElements.CREATE_ASYNC_SHOOT_FIELD_NAME
	        );
	        tableOfContentPageObject.clickOnCloseIcon();
	        log.info(" Validation passed for 'Create New Async Shoot' form field names.");
	    }

	    public void validateBookingSlotsHeaders() {
	        log.info(" Validating 'Booking Slots' table headers in Faculty Review...");
	        tableOfContentPageObject.navigateToFacultyReview();
	        tableOfContentPageObject.clickOnBookSlotsTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_BOOK_SLOTS_TAB,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'Booking Slots' table headers.");
	    }

	    public void validateShootScheduledHeaders() {
	        log.info(" Validating 'Shoot Scheduled' table headers...");
	        tableOfContentPageObject.navigateToFacultyReview();
	        tableOfContentPageObject.clickOnShootScheduledTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_SHOOT_SCHEDULED,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'Shoot Scheduled' table headers.");
	    }

	    public void validatePendingReviewHeaders() {
	        log.info(" Validating 'Pending Review' table headers...");
	        tableOfContentPageObject.navigateToFacultyReview();
	        tableOfContentPageObject.clickOnPendingReviewTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_PENDING_REVIEW,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'Pending Review' table headers.");
	    }


	

	    public void validateAllRecordsFacultyHeaders() {
	        log.info(" Validating 'All Records' table headers for Faculty in Faculty Review...");
	        tableOfContentPageObject.navigateToFacultyReview();
	        tableOfContentPageObject.clickOnAllRecordTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_FACULTY_ALL_RECORD,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'All Records' table headers for Faculty.");
	    }
	    
	    
	    public void validateAssignImageMediaUploaderHeaders() {
	        log.info(" Validating 'Assign Image Media Uploader' table headers ");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnAssignImageMediaUploaderTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_ASSIGN_IMAGE_MEDIA_UPLOAD,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'Assign Image Media Uploader' table headers for Faculty.");
	    }
	    
	    
	    public void validateUploadeTranscriptHeaders() {
	        log.info(" Validating 'upload transcript' table headers ");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnUploadTranscriptTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_UPLOAD_TRANSCRIPT,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'Assign Image Media Uploader' table headers for Faculty.");
	    }
	    
	    
	    
	    public void validateImageMediaHeaders() {
	        log.info(" Validating 'Image Media' table headers");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnImageMediaTab();
	        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_IMAGE_MEDIA,
	                TableOfContentElements.DATA_TABLE_HEADERS
	        );
	        log.info(" Validation passed for 'Image Media' table headers");
	    }
	    
    
	    
	    //Filters input titles
	    
	    
	    public void validatePlanningScheduleFilterTitle() {
	        log.info(" Validating 'Planning Schedules' filter headers...");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnPlanningSchedulesTab();
	        tableOfContentPageObject.clickOnFilterIcon();
	        waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_PLANNING_SHEDULED_FILTERS,
	                TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	        );
	        log.info(" Validation passed for 'Planning Schedules' filters title.");
	    }
	    public void validateFacultyShootScheduleFilterTitle() {
	    	log.info(" Validating 'Shoot Schedules' filter headers...");
	    	tableOfContentPageObject.navigateToFacultyReview();
	    	tableOfContentPageObject.clickOnShootScheduledTab();;
	    	tableOfContentPageObject.clickOnFilterIcon();
	    	waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	    	tableOfContentPageObject.expectedFieldName(
	    			TutorialProductionTestData.EXPECTED_HEADERS_FOR_SHOOT_SHEDULED_FILTERS,
	    			TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	    			);
	    	log.info(" Validation passed for 'Shoot Schedules' filters title.");
	    }
	        
	    
	    
	    public void validateUploadRawVideoFilterTitle() {
	        log.info(" Validating 'Upload raw video' Filters Name");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnUploadRawTab();
	        tableOfContentPageObject.clickOnFilterIcon();
	        waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_UPLOAD_RAW_VIDEOS__FILTERS,
	                TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	        );
	        log.info(" Validation passed for 'Upload raw video' filters title.");
	    }
	  
	    
	    public void validateAssignEditorFilterTitle() {
	        log.info(" Validating 'Assign Editor' Filters Name");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnAssignEditorTab();
	        tableOfContentPageObject.clickOnFilterIcon();
	        waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_ASSIGN_EDITOR_FILTERS,
	                TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	        );
	        log.info(" Validation passed for 'Assign Editor' filters title.");
	    }
	    	    
	    
	    public void validateAddVideoVersionFilterTitle() {
	    	log.info(" Validating 'add video version' Filters Name");
	    	tableOfContentPageObject.navigateToTutorialProduction();
	    	tableOfContentPageObject.clickOnAddVideoVersionTab();
	    	tableOfContentPageObject.clickOnFilterIcon();
	    	waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	    	tableOfContentPageObject.expectedFieldName(
	    			TutorialProductionTestData.EXPECTED_HEADERS_FOR_AAD_VIDEO_VERSION_FILTERS,
	    			TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	    			);
	    	log.info(" Validation passed for 'Add video version' filters title.");
	    }
	    
	    
	    public void validateAdminApprovalFilterTitle() {
	    	log.info(" Validating 'admin approval' Filters Name");
	    	tableOfContentPageObject.navigateToTutorialProduction();
	    	tableOfContentPageObject.clickOnAdminApprovalTab();
	    	tableOfContentPageObject.clickOnFilterIcon();
	    	waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	    	tableOfContentPageObject.expectedFieldName(
	    			TutorialProductionTestData.EXPECTED_HEADERS_FOR_ADMIN_APPROVAL_FILTERS,
	    			TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	    			);
	    	log.info(" Validation passed for 'Admin approval' filters title.");
	    }
	    	    

	    public void validateFeedbackReceivedFilterTitle() {
	    	log.info(" Validating 'Feedback recieved' Filters Name");
	    	tableOfContentPageObject.navigateToTutorialProduction();
	    	tableOfContentPageObject.clickOnFeedbackReceivedTab();
	    	tableOfContentPageObject.clickOnFilterIcon();
	    	waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	    	tableOfContentPageObject.expectedFieldName(
	    			TutorialProductionTestData.EXPECTED_HEADERS_FOR_FEEDBACK_RECEIVED_FILTERS,
	    			TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	    			);
	    	log.info(" Validation passed for 'Feedback received' filters title.");
	    }
	    	    
	    
	    public void validateImageMediaFilterTitle() {
	    	log.info(" Validating 'Image media' Filters Name");
	    	tableOfContentPageObject.navigateToTutorialProduction();
	    	tableOfContentPageObject.clickOnImageMediaTab();
	    	tableOfContentPageObject.clickOnFilterIcon();
	    	waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	    	tableOfContentPageObject.expectedFieldName(
	    			TutorialProductionTestData.EXPECTED_HEADERS_FOR_IMAGE_MEDIA_FILTERS,
	    			TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	    			);
	    	log.info(" Validation passed for 'Image Media' filters title.");
	    }
	    	    
	    
	    public void validateAssignImageMediaUploderFilterTitle() {
	    	log.info(" Validating 'Image media' Filters Name");
	    	tableOfContentPageObject.navigateToTutorialProduction();
	    	tableOfContentPageObject.clickOnAssignImageMediaUploaderTab();
	    	tableOfContentPageObject.clickOnFilterIcon();
	    	waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	    	tableOfContentPageObject.expectedFieldName(
	    			TutorialProductionTestData.EXPECTED_HEADERS_FOR_ASSIGN_IMAGE_MEDIA_UPLOAD_FILTERS,
	    			TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	    			);
	    	log.info(" Validation passed for 'Assign Image Media uploader' filters title.");
	    }
	    	    
	    
	    public void validateUploadTranscriptFilterTitle() {
	    	log.info(" Validating 'Upload Transcript' Filters Name");
	    	tableOfContentPageObject.navigateToTutorialProduction();
	    	tableOfContentPageObject.clickOnUploadTranscriptTab();
	    	tableOfContentPageObject.clickOnFilterIcon();
	    	waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	    	tableOfContentPageObject.expectedFieldName(
	    			TutorialProductionTestData.EXPECTED_HEADERS_FOR_UPLOAD_TRANSCRIPT_FILTERS,
	    			TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	    			);
	    	log.info(" Validation passed for 'Assign Image Media uploader' filters title.");
	    }
	    	    
	    
	    public void validateAllRecoredFilterTitle() {
	        log.info(" Validating 'All record' table headers...");
	        tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnAllRecordTab();
	        tableOfContentPageObject.clickOnFilterIcon();
	        waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	        tableOfContentPageObject.expectedFieldName(
	                TutorialProductionTestData.EXPECTED_HEADERS_FOR_ALL_RECORD_FILTERS,
	                TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	        );
	        log.info(" Validation passed for 'All record' Filters title.");
	    }
	    
	    public void validateEditorAllRecoredFilterTitle() {
	    	log.info(" Validating Editor 'All record' table headers...");
	    	tableOfContentPageObject.navigateToTutorialProduction();
	    	tableOfContentPageObject.clickOnAllRecordTab();
	    	tableOfContentPageObject.clickOnFilterIcon();
	    	waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	    	tableOfContentPageObject.expectedFieldName(
	    			TutorialProductionTestData.EXPECTED_HEADERS_FOR_EDITOR_ALL_RECORD_FILTERS,
	    			TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	    			);
	    	log.info(" Validation passed for editor 'All record' Filters title.");
	    }
	    
	    
	    public void validateBookSlotFilterTitle() {
	    	log.info(" Validating 'Book slot' table headers...");
	    	tableOfContentPageObject.navigateToFacultyReview();
	    	tableOfContentPageObject.clickOnBookSlotsTab();
	    	tableOfContentPageObject.clickOnFilterIcon();
	    	waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	    	tableOfContentPageObject.expectedFieldName(
	    			TutorialProductionTestData.EXPECTED_HEADERS_FOR_BOOK_SLOT_FILTERS,
	    			TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	    			);
	    	log.info(" Validation passed for 'All record' Filters title.");
	    }
	    
	    
	    public void validatePendingReviewFilterTitle() {
	    	log.info(" Validating 'Pending review' table headers...");
	    	tableOfContentPageObject.navigateToFacultyReview();
	    	tableOfContentPageObject.clickOnPendingReviewTab();
	    	tableOfContentPageObject.clickOnFilterIcon();
	    	waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	    	tableOfContentPageObject.expectedFieldName(
	    			TutorialProductionTestData.EXPECTED_HEADERS_FOR_PENDING_REVIEW_FILTERS,
	    			TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	    			);
	    	log.info(" Validation passed for 'Pending review' Filters title.");
	    }

	    
	    public void validateFacultyAllRecordFilterTitle() {
	    	log.info(" Validating 'All record' table headers...");
	    	tableOfContentPageObject.navigateToFacultyReview();
	    	tableOfContentPageObject.clickOnAllRecordTab();
	    	tableOfContentPageObject.clickOnFilterIcon();
	    	waitActions.waitForTableRows(TableOfContentElements.TITLE_FOR_INPUT_FILTERS);
	    	tableOfContentPageObject.expectedFieldName(
	    			TutorialProductionTestData.EXPECTED_HEADERS_FOR_FACULTY_ALL_RECORD_FILTERS,
	    			TableOfContentElements.TITLE_FOR_INPUT_FILTERS
	    			);
	    	log.info(" Validation passed for 'All record' Filters title.");
	    }
	    
	    
	    public void validateVideoContent() throws Exception {
	        log.info(" Validating video content");
	    	tableOfContentPageObject.navigateToTutorialProduction();
	        tableOfContentPageObject.clickOnAllRecordTab();
	       Thread.sleep(20000);
	    //    adminDashboardPageObject.getTotalRowCount();
	        adminDashboardPageObject.getTableData();
	        

  
	    }
	    

}
