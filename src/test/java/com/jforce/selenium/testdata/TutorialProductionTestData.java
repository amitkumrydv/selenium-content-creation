package com.jforce.selenium.testdata;

import java.util.Arrays;
import java.util.List;

import com.jforce.selenium.constants.TanstackTableContant;

public final class TutorialProductionTestData {

    private TutorialProductionTestData() {}

    public static List<String> getExpectedHeaders() {
        return Arrays.asList(
        		
            TanstackTableContant.TITLE,
            TanstackTableContant.SUBJECT,
            TanstackTableContant.PROGRAM,
            TanstackTableContant.SEMESTER,
            TanstackTableContant.SHOOT_DATE,
            TanstackTableContant.SHOOT_START_TIME,
            TanstackTableContant.SHOOT_END_TIME,
            TanstackTableContant.EDITED_HOURS,
            TanstackTableContant.IS_BILLED,
            TanstackTableContant.RECORDING_PLATFORM,
            TanstackTableContant.RECORDING_FORMAT,
            TanstackTableContant.PPT_RECEIVED_FROM_FACULTY,
            TanstackTableContant.PPT_SHARED_WITH_PRODUCTION,
            TanstackTableContant.RECORDING_SECONDS,
            TanstackTableContant.POST_PRODUCTION_STATUS,
            TanstackTableContant.PARTNER,
            TanstackTableContant.PRODUCTION_TEAM_REMARKS,
            TanstackTableContant.ACAD_TEAM_REMARKS,
            TanstackTableContant.ACTIONS
        );
    }
    
    
   
    public static final List<String> EXPECTED_HEADERS_FOR_PLANING = List.of(
    		
    	    TanstackTableContant.SR_NO,
    	    TanstackTableContant.RECORDING_fORMAT,
    	    TanstackTableContant.RECORDING_PLATFORM,
    	    TanstackTableContant.SUBJECT_CODE,
    	    TanstackTableContant.FACULTY_NAME,
    	    TanstackTableContant.ACADEMIC_COORDINATOR,
    	    TanstackTableContant.BOOKING_START_DATE,
    	    TanstackTableContant.BOOKING_END_DATE,
    	    TanstackTableContant.ACTIONS,
		    TanstackTableContant.PROGRAM,
		    TanstackTableContant.SEMESTER
    	);

	
	
	public static final List<String> EXPECTED_HEADERS_FOR_RAW_VIDEO_UPLOAD= List.of(
			
		    TanstackTableContant.TITLE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.PROGRAM,
		    TanstackTableContant.SEMESTER,
		    TanstackTableContant.SHOOT_DATE,
		    TanstackTableContant.EDITOR,
		    TanstackTableContant.EDITED_HOURS,
		    TanstackTableContant.RECORDING_PLATFORM,
		    TanstackTableContant.RECORDING_FORMAT,
		    TanstackTableContant.RECORDING_MINUTES,
		    TanstackTableContant.STUDIO,
		    TanstackTableContant.TOC_SR_NO,
		    TanstackTableContant.MODULE,
		    TanstackTableContant.STATUS,
		    TanstackTableContant.ACTIONS,
		    TanstackTableContant.RAW_VIDEO_LINK,
		    TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.TRANSCRIPT_SUMMARY
		);

    			
    			
	public static final List<String> EXPECTED_HEADERS_FOR_ADMIN_APPROVAL = List.of(
			
		    TanstackTableContant.TITLE,
		    TanstackTableContant.SHOOT_DATE,
		    TanstackTableContant.EDITOR,
		    TanstackTableContant.EDITED_HOURS,
		    TanstackTableContant.RECORDING_PLATFORM,
		    TanstackTableContant.RECORDING_FORMAT,
		    TanstackTableContant.RECORDING_MINUTES,
		    TanstackTableContant.TOC_SR_NO,
		    TanstackTableContant.MODULE,
		    TanstackTableContant.STATUS,
		    TanstackTableContant.ACTIONS,
		    TanstackTableContant.RAW_VIDEO_LINK,
		    TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.TRANSCRIPT_SUMMARY,
		    TanstackTableContant.PROGRAM,
		    TanstackTableContant.SEMESTER,
		    TanstackTableContant.STUDIO
		    
		);
	
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_CINEMATOGRAPHER_ALL_RECORDS= List.of(
			
			TanstackTableContant.TOC_SR_NO,
			TanstackTableContant.MODULE,
			TanstackTableContant.STATUS,
			TanstackTableContant.ACTIONS,
			TanstackTableContant.EDITED_HOURS,
			TanstackTableContant.RECORDING_PLATFORM,
			TanstackTableContant.RECORDING_FORMAT,
			TanstackTableContant.RECORDING_SECONDS,
			TanstackTableContant.STUDIO,
			TanstackTableContant.MEDIA_URL,
			TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
			TanstackTableContant.TRANSCRIPT_SUMMARY,
			TanstackTableContant.RAW_VIDEO_LINK,
			TanstackTableContant.TITLE,
			TanstackTableContant.SUBJECT_CODE,
			TanstackTableContant.PROGRAM,
			TanstackTableContant.SEMESTER,
			TanstackTableContant.SHOOT_DATE,
			TanstackTableContant.EDITOR
   );
 			
    			

    
	public static final List<String> EXPECTED_HEADERS_FOR_ADD_VIDEO_VERSION = List.of(
			
		    TanstackTableContant.TITLE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.EDITOR,
		    TanstackTableContant.RECORDING_MINUTES,
		    TanstackTableContant.STUDIO,
		    TanstackTableContant.TOC_SR_NO,
		    TanstackTableContant.MODULE,
		    TanstackTableContant.STATUS,
		    TanstackTableContant.ACTIONS,
		    TanstackTableContant.PROGRAM,
		    TanstackTableContant.SEMESTER,
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.RAW_VIDEO_LINK,
		    TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
		    TanstackTableContant.TRANSCRIPT_SUMMARY,
			TanstackTableContant.TOC_SR_NO,
			TanstackTableContant.MODULE,
			TanstackTableContant.FACULTY_NAME,
			TanstackTableContant.MEDIA_UPLOADER,
			TanstackTableContant.IMAGE_FEEDBACK
		    
		    
		    
		    
		);


	
	public static final List<String>  EXPECTED_HEADERS_FOR_FEEDBACK_RECEIVED  = List.of(
			
		    TanstackTableContant.TITLE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.SHOOT_DATE,
		    TanstackTableContant.EDITOR,
		    TanstackTableContant.EDITED_HOURS,
		    TanstackTableContant.RECORDING_PLATFORM,
		    TanstackTableContant.RECORDING_FORMAT,
		    TanstackTableContant.RECORDING_MINUTES,
		    TanstackTableContant.STUDIO,
		    TanstackTableContant.TOC_SR_NO,
		    TanstackTableContant.MODULE,
		    TanstackTableContant.STATUS,
		    TanstackTableContant.ACTIONS,
		    TanstackTableContant.PROGRAM,
		    TanstackTableContant.SEMESTER,
		    TanstackTableContant.RAW_VIDEO_LINK,
		    TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.TRANSCRIPT_SUMMARY
		);


	
	
	public static final List<String> EXPECTED_HEADERS_FOR_ASSIGN_EDITOR= List.of(
			
		    TanstackTableContant.TITLE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.SEMESTER,
		    TanstackTableContant.EDITOR,
		    TanstackTableContant.RECORDING_MINUTES,
		    TanstackTableContant.RAW_VIDEO_LINK,
		    TanstackTableContant.ACTIONS
		  
		);

	
	public static final List<String> EXPECTED_HEADERS_FOR_ADMIN_ALL_RECORDS = List.of(
			
		    TanstackTableContant.TITLE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.SHOOT_DATE,
		    TanstackTableContant.EDITOR,
		    TanstackTableContant.EDITED_HOURS,
		    TanstackTableContant.RECORDING_PLATFORM,
		    TanstackTableContant.RECORDING_FORMAT,
		    TanstackTableContant.RECORDING_SECONDS,
		    TanstackTableContant.STUDIO,
		    TanstackTableContant.TOC_SR_NO,
		    TanstackTableContant.MODULE,
		    TanstackTableContant.STATUS,
		    TanstackTableContant.ACTIONS,
		    TanstackTableContant.PROGRAM,
		    TanstackTableContant.SEMESTER,
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.RAW_VIDEO_LINK,
		    TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
		    TanstackTableContant.TRANSCRIPT_SUMMARY,
		    TanstackTableContant.MEDIA_UPLOADER,
		    TanstackTableContant.FACULTY_NAME
		    
		);
	
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_EDITORTEAM_LEAD_ALL_RECORDS = List.of(
			
		    TanstackTableContant.TITLE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.SHOOT_DATE,
		    TanstackTableContant.EDITOR,
		    TanstackTableContant.EDITED_HOURS,
		    TanstackTableContant.RECORDING_PLATFORM,
		    TanstackTableContant.RECORDING_FORMAT,
		    TanstackTableContant.RECORDING_MINUTES,
		    TanstackTableContant.IMAGE_FEEDBACK,
		    TanstackTableContant.STUDIO,
		    TanstackTableContant.TOC_SR_NO,
		    TanstackTableContant.MODULE,
		    TanstackTableContant.STATUS,
		    TanstackTableContant.ACTIONS,
		    TanstackTableContant.PROGRAM,
		    TanstackTableContant.SEMESTER,
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.RAW_VIDEO_LINK,
		    TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
		    TanstackTableContant.TRANSCRIPT_SUMMARY,
		    TanstackTableContant.MEDIA_UPLOADER,
		    TanstackTableContant.FACULTY_NAME,
		    TanstackTableContant.MEDIA_UPLOADER,
		    TanstackTableContant.FACULTY_NAME,
		    TanstackTableContant.ASYNC_NAME
		);

	
	public static final List<String> EXPECTED_HEADERS_FOR_EDITOR_ALL_RECORDS = List.of(
			
		    TanstackTableContant.TITLE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.SHOOT_DATE,
		    TanstackTableContant.EDITOR,
		    TanstackTableContant.EDITED_HOURS,
		    TanstackTableContant.RECORDING_PLATFORM,
		    TanstackTableContant.RECORDING_FORMAT,
		    TanstackTableContant.RECORDING_MINUTES,
		    TanstackTableContant.STUDIO,
		    TanstackTableContant.TOC_SR_NO,
		    TanstackTableContant.MODULE,
		    TanstackTableContant.STATUS,
		    TanstackTableContant.PROGRAM,
		    TanstackTableContant.SEMESTER,
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.RAW_VIDEO_LINK,
		    TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
		    TanstackTableContant.TRANSCRIPT_SUMMARY,
		    TanstackTableContant.MEDIA_UPLOADER,
		    TanstackTableContant.FACULTY_NAME,
		    TanstackTableContant.IMAGE_FEEDBACK,
		    TanstackTableContant.ASYNC_NAME,
		    TanstackTableContant.ACTIONS
		    
		);
	

	
	public static final List<String> EXPECTED_HEADERS_FOR_BOOK_SLOTS_TAB = List.of(
			
		    TanstackTableContant.SR_NO,
		    TanstackTableContant.MODULE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.ACTIONS
		);
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_SHOOT_SCHEDULED= List.of(
			
		    TanstackTableContant.SR_NO,
		    TanstackTableContant.SHOOT_DATE,
		    TanstackTableContant.SHOOT_START_TIME,
		    TanstackTableContant.SHOOT_END_TIME,
		    TanstackTableContant.RECORDING_PLATFORM,
		    TanstackTableContant.STUDIO,
		    TanstackTableContant.CONTENT_RECEIVED_FROM_FACULTY,
		    TanstackTableContant.CONTENT_SHARED_WITH_PRODUCTION,
		    TanstackTableContant.STATUS,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.TOC_SR_NO,
		    TanstackTableContant.MODULE,
		    TanstackTableContant.ACTIONS
		);

	
	public static final List<String> EXPECTED_HEADERS_FOR_PENDING_REVIEW = List.of(
			
		    TanstackTableContant.SR_NO,
		    TanstackTableContant.ASYNC_NAME,
		    TanstackTableContant.SHOOT_DATE,
		    TanstackTableContant.SHOOT_START_TIME,
		    TanstackTableContant.SHOOT_END_TIME,
		    TanstackTableContant.RECORDING_MINUTES,
		    TanstackTableContant.STUDIO,
		    TanstackTableContant.RECORDING_PLATFORM,
		    TanstackTableContant.VIDEO_TITLE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.STATUS,
		    TanstackTableContant.TOC_SR_NO,
		    TanstackTableContant.MODULE,
		    TanstackTableContant.ACTIONS
		);

	
	
	public static final List<String> EXPECTED_HEADERS_FOR_FACULTY_ALL_RECORD = List.of(
			
		    TanstackTableContant.SR_NO,
		    TanstackTableContant.SHOOT_DATE,
		    TanstackTableContant.SHOOT_START_TIME,
		    TanstackTableContant.SHOOT_END_TIME,
		    TanstackTableContant.STUDIO,
		    TanstackTableContant.RECORDING_PLATFORM,
		    TanstackTableContant.VIDEO_TITLE,
		    TanstackTableContant.VIDEO_COVERAGE,
		    TanstackTableContant.ACADEMIC_COORDINATOR,
		    TanstackTableContant.EDITOR_ASSIGNED,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.STATUS,
		    TanstackTableContant.TOC_SR_NO,
		    TanstackTableContant.MODULE,
		    TanstackTableContant.ACTIONS
		);
	
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_IMAGE_MEDIA = List.of(
			
			TanstackTableContant.TITLE,
			TanstackTableContant.EDITOR,
			TanstackTableContant.TRANSCRIPT_SUMMARY,
			TanstackTableContant.RECORDING_MINUTES,
			TanstackTableContant.ACTIONS


		);

	
	
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_ASSIGN_IMAGE_MEDIA_UPLOAD = List.of(
			
		    TanstackTableContant.RECORDING_MINUTES,
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.ACTIONS,
		    TanstackTableContant.TITLE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.EDITOR,
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.TRANSCRIPT_SUMMARY,
		    TanstackTableContant.IMAGE_UPLOADER
		    
		);
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_UPLOAD_TRANSCRIPT = List.of(
			
			TanstackTableContant.PROGRAM,
			TanstackTableContant.SEMESTER,
			TanstackTableContant.EDITOR,
			TanstackTableContant.STUDIO,
			TanstackTableContant.TOC_SR_NO,
			TanstackTableContant.MODULE,
			TanstackTableContant.STATUS,
			TanstackTableContant.ACTIONS,
			TanstackTableContant.TITLE,
			TanstackTableContant.SUBJECT_CODE,
			TanstackTableContant.MEDIA_URL,
			TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
			TanstackTableContant.RAW_VIDEO_LINK,
			TanstackTableContant.TRANSCRIPT_SUMMARY

	);
	
	

	

	//Filters
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_PLANNING_SHEDULED_FILTERS = List.of(
			
			TanstackTableContant.RECORDING_fORMAT,
			TanstackTableContant.RECORDING_PLATFORM,
			TanstackTableContant.SUBJECT_CODE,
			TanstackTableContant.PROGRAM,
			TanstackTableContant.SEMESTER,
			TanstackTableContant.FACULTY_NAME,
			TanstackTableContant.ACADEMIC_COORDINATOR,
			TanstackTableContant.BOOKING_START_DATE,
			TanstackTableContant.BOOKING_END_DATE

         );
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_UPLOAD_RAW_VIDEOS__FILTERS = List.of(
			
			TanstackTableContant.TITLE,
			TanstackTableContant.SUBJECT_CODE,
			TanstackTableContant.PROGRAM,
			TanstackTableContant.SEMESTER,
			TanstackTableContant.SHOOT_DATE,
			TanstackTableContant.EDITOR,
			TanstackTableContant.RECORDING_PLATFORM,
			TanstackTableContant.RECORDING_FORMAT,
			TanstackTableContant.STUDIO,
			TanstackTableContant.MEDIA_URL,
			TanstackTableContant.RAW_VIDEO_LINK,
			TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
			TanstackTableContant.TRANSCRIPT_SUMMARY,
			TanstackTableContant.TOC_SR_NO,
			TanstackTableContant.MODULE

		);
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_ASSIGN_EDITOR_FILTERS = List.of(
			
			TanstackTableContant.TITLE,
			TanstackTableContant.SUBJECT_CODE,
			TanstackTableContant.EDITOR,
			TanstackTableContant.RAW_VIDEO_LINK,
            TanstackTableContant.SEMESTER


		);
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_AAD_VIDEO_VERSION_FILTERS = List.of(
			
			TanstackTableContant.TITLE,
			TanstackTableContant.SUBJECT_CODE,
			TanstackTableContant.PROGRAM,
			TanstackTableContant.SEMESTER,
			TanstackTableContant.EDITOR,
			TanstackTableContant.STUDIO,
			TanstackTableContant.MEDIA_URL,
			TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
			TanstackTableContant.RAW_VIDEO_LINK,
			TanstackTableContant.TRANSCRIPT_SUMMARY,
			TanstackTableContant.TOC_SR_NO,
			TanstackTableContant.MODULE,
			TanstackTableContant.FACULTY_NAME,
			TanstackTableContant.MEDIA_UPLOADER,
			TanstackTableContant.IMAGE_FEEDBACK

		);
	
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_ADMIN_APPROVAL_FILTERS = List.of(
			
			TanstackTableContant.TITLE,
			TanstackTableContant.SHOOT_DATE,
			TanstackTableContant.EDITOR,
			TanstackTableContant.RECORDING_PLATFORM,
			TanstackTableContant.RECORDING_FORMAT,
			TanstackTableContant.MEDIA_URL,
			TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
			TanstackTableContant.RAW_VIDEO_LINK,
			TanstackTableContant.TRANSCRIPT_SUMMARY,
			TanstackTableContant.TOC_SR_NO,
			TanstackTableContant.MODULE,
			TanstackTableContant.PROGRAM,
			TanstackTableContant.SEMESTER,
			TanstackTableContant.STUDIO
			

			
			);


	
	
	public static final List<String> EXPECTED_HEADERS_FOR_FEEDBACK_RECEIVED_FILTERS = List.of(
			
			TanstackTableContant.TITLE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.PROGRAM,
		    TanstackTableContant.SEMESTER,
		    TanstackTableContant.SHOOT_DATE,
		    TanstackTableContant.EDITOR,
		    TanstackTableContant.RECORDING_PLATFORM,
		    TanstackTableContant.RECORDING_FORMAT,
		    TanstackTableContant.STUDIO,
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
		    TanstackTableContant.RAW_VIDEO_LINK,
		    TanstackTableContant.TRANSCRIPT_SUMMARY,
		    TanstackTableContant.TOC_SR_NO,
		    TanstackTableContant.MODULE,
			TanstackTableContant.TOC_SR_NO,
			TanstackTableContant.MODULE
			
			
			);
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_IMAGE_MEDIA_FILTERS = List.of(
			
			TanstackTableContant.TITLE,
			TanstackTableContant.EDITOR,
			TanstackTableContant.TRANSCRIPT_SUMMARY


			
			);
	
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_ASSIGN_IMAGE_MEDIA_UPLOAD_FILTERS = List.of(
			
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.TITLE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.EDITOR,
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.TRANSCRIPT_SUMMARY,
		    TanstackTableContant.IMAGE_UPLOADER
		    
			
	);
			
	
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_UPLOAD_TRANSCRIPT_FILTERS = List.of(
			
		    TanstackTableContant.TITLE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
		    TanstackTableContant.RAW_VIDEO_LINK,
		    TanstackTableContant.TRANSCRIPT_SUMMARY,
		    TanstackTableContant.PROGRAM,
		    TanstackTableContant.SEMESTER,
		    TanstackTableContant.EDITOR,
		    TanstackTableContant.STUDIO
			
			
			);
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_ALL_RECORD_FILTERS = List.of(
			
		    TanstackTableContant.TITLE,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.PROGRAM,
		    TanstackTableContant.SEMESTER,
		    TanstackTableContant.SHOOT_DATE,
		    TanstackTableContant.RECORDING_PLATFORM,
		    TanstackTableContant.RECORDING_FORMAT,
		    TanstackTableContant.STUDIO,
		    TanstackTableContant.MEDIA_URL,
		    TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
		    TanstackTableContant.RAW_VIDEO_LINK,
		    TanstackTableContant.TRANSCRIPT_SUMMARY,
		    TanstackTableContant.EDITOR,
			TanstackTableContant.TOC_SR_NO,
			TanstackTableContant.MODULE,
		    TanstackTableContant.MEDIA_UPLOADER,
		    TanstackTableContant.FACULTY_NAME,
		    TanstackTableContant.STATUS,
		    TanstackTableContant.ASYNC_NAME
	);
	
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_EDITOR_ALL_RECORD_FILTERS = List.of(
			
			TanstackTableContant.TITLE,
			TanstackTableContant.SUBJECT_CODE,
			TanstackTableContant.PROGRAM,
			TanstackTableContant.SEMESTER,
			TanstackTableContant.SHOOT_DATE,
			TanstackTableContant.RECORDING_PLATFORM,
			TanstackTableContant.RECORDING_FORMAT,
			TanstackTableContant.STUDIO,
			TanstackTableContant.MEDIA_URL,
			TanstackTableContant.RAW_VIDEO_TRANSCRIPT_LINK,
			TanstackTableContant.RAW_VIDEO_LINK,
			TanstackTableContant.TRANSCRIPT_SUMMARY,
			TanstackTableContant.EDITOR,
			TanstackTableContant.TOC_SR_NO,
			TanstackTableContant.MODULE,
		    TanstackTableContant.MEDIA_UPLOADER,
		    TanstackTableContant.FACULTY_NAME,
		    TanstackTableContant.STATUS,
		    TanstackTableContant.ASYNC_NAME
		    
			
			);
	
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_BOOK_SLOT_FILTERS = List.of(
			
			TanstackTableContant.SR_NO,
			TanstackTableContant.MODULE,
			  TanstackTableContant.SUBJECT_CODE
			
			);
	
	public static final List<String> EXPECTED_HEADERS_FOR_PENDING_REVIEW_FILTERS = List.of(

			TanstackTableContant.SHOOT_DATE,
			TanstackTableContant.SHOOT_START_TIME,
			TanstackTableContant.SHOOT_END_TIME,
			TanstackTableContant.STUDIO,
			TanstackTableContant.RECORDING_PLATFORM,
			TanstackTableContant.VIDEO_TITLE,
			TanstackTableContant.SUBJECT_CODE,
			TanstackTableContant.TOC_SR_NO,
			TanstackTableContant.MODULE
			);
	
	
	public static final List<String> EXPECTED_HEADERS_FOR_SHOOT_SHEDULED_FILTERS = List.of(
			
		    TanstackTableContant.SHOOT_DATE,
		    TanstackTableContant.SHOOT_START_TIME,
		    TanstackTableContant.SHOOT_END_TIME,
		    TanstackTableContant.RECORDING_PLATFORM,
		    TanstackTableContant.STUDIO,
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.CONTENT_RECEIVED_FROM_FACULTY,
		    TanstackTableContant.CONTENT_SHARED_WITH_PRODUCTION,
		    TanstackTableContant.STATUS,
		    TanstackTableContant.TOC_SR_NO,
		    TanstackTableContant.MODULE
			
			
			);
	
	

	public static final List<String> EXPECTED_HEADERS_FOR_FACULTY_ALL_RECORD_FILTERS = List.of(
			
			TanstackTableContant.SHOOT_DATE,
			TanstackTableContant.SHOOT_START_TIME,
			TanstackTableContant.SHOOT_END_TIME,
			TanstackTableContant.STUDIO,
			TanstackTableContant.RECORDING_PLATFORM,
			TanstackTableContant.VIDEO_TITLE,
			TanstackTableContant.SUBJECT_CODE,
			TanstackTableContant.STATUS,
			TanstackTableContant.ACADEMIC_COORDINATOR,
			TanstackTableContant.EDITOR_ASSIGNED,
			TanstackTableContant.TOC_SR_NO,
			TanstackTableContant.MODULE

		);

	
		/**
		 *  Create async shoot 
		 */

	public static final List<String> EXPECTED_HEADERS_FOR_CREATE_NEW_ASYNC_SHOOT = List.of(
			
		    TanstackTableContant.SUBJECT_CODE,
		    TanstackTableContant.ACADEMIC_COORDINATOR,
		    TanstackTableContant.SHOOT_START_DATE,
		    TanstackTableContant.SHOOT_END_DATE,
		    TanstackTableContant.RECORDING_PLATFORM,
		    TanstackTableContant.RECORDING_FORMAT,
		    TanstackTableContant.FACULTY_NAME,
		    TanstackTableContant.CONTENT_RECEIVED_FROM_FACULTY,
		    TanstackTableContant.CONTENT_SHARED_WITH_PRODUCTION_PLAN,
		    TanstackTableContant.SCHEDULE_RECORDING_BUTTON,
		    TanstackTableContant.RESET_FORM_BUTTON
		);

    
}
