package com.jforce.selenium.test;

import org.junit.jupiter.api.DisplayName;
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
public class EditorTeamLead extends Common {

	@Autowired private TanStackTableConstantValidation validations;

    @Override
    protected String getRoleForTest() {
        return "BU_LEAD_EDITOR";
    }

    @Test(testName = "Verify 'Assign Editor' table headers in Tutorial Production")
    public void verifyAssignEditorTableHeaders() {
        validations.validateAssignEditorHeaders();
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
    public void verifyAllRecordHeader() {
        validations.validateAllRecordHeadersAdmin();
    }
    
    
    @Test
    @DisplayName("Verify Image Media tab headers")
    @Description("Checks that all expected headers in the Image Media tab are displayed correctly and in the correct order.")
    public void verifyImageMediaHeaders() {
        validations.validateImageMediaHeaders();
    }


    
}
