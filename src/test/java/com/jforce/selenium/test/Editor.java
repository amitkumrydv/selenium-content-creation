package com.jforce.selenium.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.common.Common;
import com.jforce.selenium.elements.TableOfContentElements;
import com.jforce.selenium.listeners.TestListener;
import com.jforce.selenium.pageObject.TableOfContentPageObject;
import com.jforce.selenium.testdata.TabForDataTable;
import com.jforce.selenium.testdata.TutorialProductionTestData;
import com.jforce.selenium.validations.TanStackTableConstantValidation;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;

@Epic("TOC:PEJ-255")
@TmsLink("TMS-004")
@Listeners(TestListener.class)
public class Editor extends Common {

	@Autowired private TanStackTableConstantValidation validations;

    @Override
    protected String getRoleForTest() {
        return "EDITOR";
    }

    @Test(testName = "Verify 'Add Video Version' table headers in Tutorial Production")
    public void verifyAddVideoVersionTableHeaders() {
        validations.validateAddVideoVersionHeaders();
    }

    @Test(testName = "Verify 'Feedback Received' table headers in Tutorial Production")
    public void verifyFeedbackReceivedTableHeaders() {
        validations.validateFeedbackReceivedHeaders();
    }

    @Test(testName = "Verify 'All Records' table headers for Editor Team Lead in Tutorial Production")
    public void verifyAllRecordHeaderforEditor() {
        validations.validateAllRecordHeadersEditor();
    }
   
    
    // Filters
    
    @Test(testName = "Verify 'Filter title For Add Video Version' table headers")
    @Description("Validate that the 'Add Video Version' tab displays the correct filter titles (table headers) for Admin.")
    public void verifyAddVideoVersionTableHeadersFilter() {
        validations.validateAddVideoVersionFilterTitle();
    }
    
    
    @Test(testName = "Verify 'Filter title For Feedback Received' table headers")
    @Description("Validate that the 'Feedback Received' tab displays the correct filter titles (table headers) for Admin.")
    public void verifyFeedbackReceivedTableHeadersFilter() {
        validations.validateFeedbackReceivedFilterTitle();
    }
    
    
    @Test(testName = "Verify 'Filter title For Upload Transcript' table headers")
    @Description("Validate that the 'Upload Transcript' tab displays the correct filter titles (table headers) for Admin.")
    public void verifyUploadTranscriptTableHeadersFilter() {
        validations.validateUploadTranscriptFilterTitle();
    }

    
    @Test(testName = "Verify 'Filter title For  All Records' table headers ")
    @Description("Validate that the 'All Records' tab displays the correct filter titles (table headers) for Admin.")
    public void verifyAllRecordTableHeadersFilter() {
    	validations.validateEditorAllRecoredFilterTitle();
    }
    
    
  
    
    
}
