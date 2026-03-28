package com.jforce.selenium.pageObject;

import static com.jforce.selenium.constants.EndPointConstants.ENDPOINT_LTI;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jforce.selenium.actions.ElementActions;
import com.jforce.selenium.actions.JavaScriptActions;
import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.common.CommonPageObject;
import com.jforce.selenium.config.FFmpegConfig;
import com.jforce.selenium.config.VideoTextValidator;
import com.jforce.selenium.elements.AdminDashboardElements;
import com.jforce.selenium.utility.ValidationFromExcel;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AdminDashboardPageObject extends CommonPageObject {

    // ------------------------------------------------------------
    // Dependencies
    // ------------------------------------------------------------
    @Autowired private ElementActions uiElements;
    @Autowired private TableOfContentPageObject tableOfContentPageObject;
    @Autowired private WaitActions waitActions;
    @Autowired private JavaScriptActions javaScriptActions;

    final String filePath = System.getProperty("user.dir");

    // ------------------------------------------------------------
    // Navigation
    // ------------------------------------------------------------

    /**
     * Opens the Admin LTI Dashboard.
     */
    @Step("Open the Admin LTI Dashboard")
    public void openAdminLtiDashboard() {
        log.info("Opening Admin LTI Dashboard...");
        iUIElements.openURL(seleniumProperties.getBaseUrl() + ENDPOINT_LTI);
        log.info("Admin LTI Dashboard opened successfully.");
    }

    // ------------------------------------------------------------
    // Table Header Validation
    // ------------------------------------------------------------

    /**
     * Fetches and validates table header names from the admin dashboard.
     *
     * @return a list of header names found in the data table
     */
    @Step("Store the data table header names")
    public List<String> getValidatedTableHeaders() {
        log.info("Fetching table header names...");
        List<String> headers = new ArrayList<>();

        int count = uiElements.getSize(AdminDashboardElements.DATA_TABLE_HEADERS);
        log.info("Total headers found: {}", count);

        for (int i = 0; i < count; i++) {
            String text = uiElements.findElementsbyIndex(AdminDashboardElements.DATA_TABLE_HEADERS, i).trim();
            if (!text.isEmpty()) {
                log.info("Header text [{}]: {}", i, text);
                headers.add(text);
            }
        }

        log.info("Final list of headers: {}", headers);
        return headers;
    }

    // ------------------------------------------------------------
    // Subject Validation
    // ------------------------------------------------------------

    /**
     * Validates the list of subjects displayed in the dropdown
     * against the expected list in an Excel file.
     */
    public void compareCourses() {
        log.info("Starting subject list validation...");

        String message = "Subjects list";

        List<String> actualCourses = javaScriptActions.getListByText(
                AdminDashboardElements.LIST_OF_SUBJECT_IN_DROPDOWN);
        log.info("Actual subjects retrieved from UI: {}", actualCourses);

        final String FILE_PATH = filePath + "/test-data/BU_Courses_List.xlsx";
        log.info("Reading subject list from Excel file: {}", FILE_PATH);

        List<String> expectedSubjectList = ValidationFromExcel.readSubjectListInExcel(FILE_PATH, "subject_list");
        log.info("Expected subjects retrieved from Excel: {}", expectedSubjectList);

        ValidationFromExcel.compareLists(expectedSubjectList, actualCourses, message);
        log.info("Subject list validation completed.");
    }

    // ------------------------------------------------------------
    // UI Actions
    // ------------------------------------------------------------

    /**
     * Clicks on the subject dropdown.
     */
    @Step("Click on the subject dropdown")
    public void clickOnTheSubjectDropdown() {
        log.info("Clicking on the subject dropdown...");
        uiElements.click(AdminDashboardElements.SUBJECT_DROPDOWN);
        log.info("Subject dropdown clicked.");
    }

    /**
     * Clicks on the Edit Uploaded Video button for a given row index.
     *
     * @param rowIndex the index of the row containing the edit button
     */
    @Step("Move on the element and click on the Edit uploaded video button")
    public void clickOnEditUploadedVideo(int rowIndex) {
        javaScriptActions.scrollByClick(AdminDashboardElements.editorButtonInActionColumn(rowIndex));
    }

    /**
     * Clicks on the Uploaded Video button.
     */
    @Step("click on the uploaded video button")
    public void clickOnUploadedVideo() {
        uiElements.click(AdminDashboardElements.UPLOAD_VIDEO_BUTTON);
    }

    /**
     * Clicks on the Faculty dropdown.
     */
    @Step("Click on the Faculty dropdown")
    public void clickOnTheFacultyDropdown() {
        uiElements.click(AdminDashboardElements.FACULTY_NAME_DROPDOWN);
    }

    /**
     * Clicks on the latest video version link and switches window.
     */
    @Step("Click on the video link")
    public void clickOnTheVideo() {
        javaScriptActions.clickOnLatestElementAndSwithWindow(AdminDashboardElements.VIDEO_VERSION_LINK);
    }

    /**
     * Retrieves the video URL from the table.
     *
     * @return video URL as String
     */
    @Step("Get the video link")
    public String getTheVideoURL() {
        javaScriptActions.scrollByElement(AdminDashboardElements.VIDEO_VERSION_LINK);
        String url = javaScriptActions.getAttributeUsingJS(AdminDashboardElements.VIDEO_VERSION_LINK, "href");
        return url;
    }

    // ------------------------------------------------------------
    // Workflows
    // ------------------------------------------------------------

    /**
     * Navigates to the tutorial production page and validates subjects
     * in the subject dropdown.
     */
    @Step("Enter the subject dropdown and validate subjects")
    public void enterTheSubjectDropDown() {
        log.info("Navigating to tutorial production page...");
        tableOfContentPageObject.navigateToTutorialProduction();

        waitActions.waitForPageLoad();
        log.info("Page loaded successfully.");

        tableOfContentPageObject.clickOnCreateNewAsyncShoot();

        clickOnTheSubjectDropdown();
        compareCourses();

        log.info("Subject dropdown validation workflow completed.");
    }

    /**
     * Clicks on the Academic Coordinator dropdown.
     */
    @Step("Click on the academic coordinator dropdown")
    public void clickOnAcadmicCoordinaterDropdown() {
        uiElements.click(AdminDashboardElements.ACADMIC_COORDINATER_DROPDOWN);
    }

    /**
     * Validates the Academic Coordinator list from UI against Excel data.
     */
    @Step("Compare the coordinator names")
    public void compareAcadCoorinaterList() {
        log.info("Starting academic coordinator list validation...");

        String message = "Academic coordinator";
        final String excelFileForCoordinator = filePath + "/test-data/Acadmic_Co-ordinater.xlsx";

        List<String> expectedSubjectList = ValidationFromExcel.readSubjectListInExcel(
                excelFileForCoordinator, "acadmic_coordinater");
        List<String> actualCourses = javaScriptActions.getListByText(
                AdminDashboardElements.LIST_OF_ACADMIC_COORDINATER_IN_DROPDOWN);

        ValidationFromExcel.compareLists(expectedSubjectList, actualCourses, message);
        log.info("Academic coordinator list validation completed.");
    }

    /**
     * Validates the academic coordinator dropdown workflow.
     */
    @Step("Enter the academic coordinator dropdown and validate list")
    public void listOfAcadCoordinaterInDropDown() {
        clickOnAcadmicCoordinaterDropdown();
        compareAcadCoorinaterList();
        log.info("Academic coordinator dropdown validation workflow completed.");
    }

    /**
     * Compares faculty list from UI with Excel file.
     */
    @Step("Validate the faculty drop-down list")
    public void compareFacultyList() {
        log.info("Starting Faculty list validation...");

        String message = "Faculty list";
        final String excelFileForCoordinator = filePath + "/test-data/Faculty-List.xlsx";

        List<String> expectedSubjectList = ValidationFromExcel.readSubjectListInExcel(
                excelFileForCoordinator, "Faculty_list");
        List<String> actualCourses = javaScriptActions.getListByText(
                AdminDashboardElements.FACULTY_LIST_IN_DROPDOWN);

        ValidationFromExcel.compareLists(expectedSubjectList, actualCourses, message);
        log.info("Faculty list validation completed.");
    }

    /**
     * Validates the Faculty dropdown workflow.
     */
    @Step("Validate faculty list")
    public void validateTheFacultyList() {
        clickOnTheFacultyDropdown();
        compareFacultyList();
        log.info("Faculty dropdown validation workflow completed.");
    }

    // ------------------------------------------------------------
    // Table Data & Pagination
    // ------------------------------------------------------------

    /**
     * Retrieves total number of rows from pagination text.
     *
     * @return total row count as Integer
     */
    public Integer getTotalRowCount() {
        String paginationText = uiElements.getTextByLoadPageAndScroll(AdminDashboardElements.PAGINATION_COUNT);
        int start = paginationText.indexOf(" of ") + " of ".length();
        int end = paginationText.indexOf(" rows");

        String lastNumber = paginationText.substring(start, end).trim();
        int totalcount = Integer.parseInt(lastNumber);
        return totalcount;
    }

    /**
     * Retrieves video title text from table.
     *
     * @return video title text
     */
    public String getVideoTitleFromTheTable() {
        WebElement tableRows = waitActions.waitForVisibility(AdminDashboardElements.getTableCellLocator(3, 2));
        log.info("Get first element from tableRows: {}", tableRows.getText());
        return tableRows.getText();
    }

    /**
     * Fetches and validates video data from the admin dashboard table.
     * It reads total rows, extracts video title, processes the video, and validates the text.
     *
     * @return list of row text values
     * @throws Exception if FFmpeg or validation fails
     */
    public List<String> getTableData() throws Exception {
        waitActions.waitForPageLoad();
        int totalRows = getTotalRowCount();
        List<String> rowText = new ArrayList<>();

        String videoTitle = getVideoTitleFromTheTable();
        clickOnEditUploadedVideo(3);
        clickOnUploadedVideo();

        String geturl = getTheVideoURL();

        FFmpegConfig.mainMethod(geturl);
        VideoTextValidator.mainValidationText(videoTitle);

        return rowText;
    }
}
