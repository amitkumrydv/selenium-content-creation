package com.jforce.selenium.elements;


import org.openqa.selenium.By;


public class AdminDashboardElements {

	
	public static final By MENU= By.xpath("//button[span[text()='Menu']]");
	public static final By EDITOR_DASHBOARD= By.xpath("//a[span[text()='Editor Dashboard']]");
    public static final By DATA_TABLE_HEADERS = By.xpath("//th[@colspan=1]");
	public static final By CREATE_NEW_ASYNC_SHOOT= By.xpath("//button[span[text()='Create New Async Shoot']]");
	public static final By COLUMN= By.id("toolbar-column-toggle");
	public static final By FILTER_ICON= By.xpath("//button[@aria-label='Show column filters']");
	public static final By INPUT_GLOBAL_SEARCH_FILTER= By.xpath("//input[@aria-label=\"Global search filter\"]");
	public static final By PLANNING_SCHEDILES_TAB= By.xpath("//button[@id=\"faculty-dashboard-tabs-tab-TemplatePage\"]");
	public static final By EDITOR_DASHBOARD_TAB= By.xpath("//button[@id=\"faculty-dashboard-tabs-tab-EditorDashboard\"]");
	
	
	public static final By SUBJECT_DROPDOWN= By.id("dropdown-subjectCode");
	public static final By LIST_OF_SUBJECT_IN_DROPDOWN = 
			             By.xpath("//div[@x-placement='bottom-start']//a[not(contains(text(),'No options found'))]");
	
	
	public static final By ACADMIC_COORDINATER_DROPDOWN = By.id("dropdown-academicCoordinatorId");
	public static final By LIST_OF_ACADMIC_COORDINATER_IN_DROPDOWN = By.xpath("//div[@aria-labelledby='dropdown-academicCoordinatorId']//a");
	
	public static final By FACULTY_NAME_DROPDOWN = By.id("dropdown-facultyId");
	public static final By FACULTY_LIST_IN_DROPDOWN = By.id("//div[@aria-labelledby=\"dropdown-facultyId\"]//a");
	
	

	public static final By PAGINATION_COUNT = By.xpath("//div[contains(@class, 'text-muted') and contains(text(), 'Showing')]");
	public static final By UPLOAD_VIDEO_BUTTON = By.xpath("//button[normalize-space(text())='Upload video']");
	public static final By VIDEO_VERSION_LINK = By.xpath("//a[@class='me-3 w-50 overflow-hidden'][last()]");
	
	
	
	
	/**
	 * Get cell text from a dynamic table using row and column index.
	 *
	 * @param rowIndex Row number (1-based)
	 * @param colIndex Column number (1-based)
	 * @return The text of the specific cell
	 */
    public static By getTableCellLocator(int rowIndex, int colIndex) {
        String xpath = String.format("//tbody//tr[%d]//td[%d]", rowIndex, colIndex);
        return By.xpath(xpath);
    }
    public static By editorButtonInActionColumn(int rowIndex) {
    	String xpath = String.format("//tbody//tr[%d]//td//button[text()='Edit uploaded video']", rowIndex);
    	return By.xpath(xpath);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
}
