package com.jforce.selenium.elements;

import org.openqa.selenium.By;


public class TableOfContentElements {

	
	public static final By MENU= By.xpath("//button[span[text()='Menu']]");
	public static final By COLUMN= By.id("toolbar-column-toggle");
	public static final By GLOBAL_SEARCH_FILTER= By.xpath("//input[@aria-label=\"Global search filter\"]");
    public static final By DATA_TABLE_HEADERS = By.cssSelector("th[colspan='1'] div.header-content");
	public static final By CLOSE_POPUP= By.cssSelector("button.btn-close");
	
	// Admin role
	public static final By E_TUTORIAL_PRODUCTION= By.xpath("//a[span[text()='E-Tutorial Production']]");
	public static final By CREATE_NEW_ASYNC_SHOOT= By.xpath("//button[span[text()='Create New Async Shoot']]");
	public static final By PLANNING_SCHEDULES= By.xpath("//button[normalize-space()='Planning Schedules']");
	public static final By ADMIN_APPROVAL_TAB= By.xpath("//button[normalize-space()='Admin Approval']");
	public static final By UPLOAD_RAW_TAB= By.xpath("//button[normalize-space()='Upload Raw Video']");
	public static final By ASSIGN_EDITOR_TAB= By.xpath("//button[normalize-space()='Assign Editor']");
	public static final By ADD_VIDEO_VERSION_TAB= By.xpath("//button[normalize-space()='Add Video Version']");
	public static final By FEEDBACK_RECEIVED_TAB= By.xpath("//button[normalize-space()='Feedback Received']");
	public static final By CREATE_ASYNC_SHOOT_FIELD_NAME= By.xpath("//label[@class='form-label']");
	public static final By ALL_RECORDS_TAB= By.xpath("//button[normalize-space()='All Records']");
	public static final By UPLOAD_TRANSCRIPT_TAB= By.xpath("//button[text()='Upload Transcript']");
	
	
	public static final By IMAGE_MEDIA_TAB= By.xpath("//button[text()='Image Media']");
	public static final By ASSIGN_IMAGE_MEDIA_UPLOAD_TAB= By.xpath("//button[text()='Assign Image Media Uploader']");
	
	
	//Faculty Review
	public static final By FEEDBACK_REPORT= By.xpath("//a[span[text()='Feedback Reports']]");
	public static final By FACULTY_REVIEW_SIDEBAR= By.xpath("//span[text()='Faculty Review']");
	public static final By BOOK_SLOTS_TAB= By.xpath("//button[text()='Book Slots']");
	public static final By SHOOT_SCHEDULED_TAB= By.xpath("//button[text()='Shoot Scheduled']");
	public static final By PENDING_REVIEW_TAB= By.xpath("//button[text()='Pending Review']");

	//Filter
	
	public static final By FILTER_ICON= By.xpath("//button[@aria-label='Show column filters']");
	public static final By TITLE_FOR_INPUT_FILTERS= By.xpath("//label[@class=\"small mb-1 fw-medium form-label\"]");
	

	
	
	
	
	

	
	
	


	
}
