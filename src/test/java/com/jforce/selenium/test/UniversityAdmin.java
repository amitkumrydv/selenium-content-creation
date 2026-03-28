package com.jforce.selenium.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.common.Common;
import com.jforce.selenium.elements.TableOfContentElements;
import com.jforce.selenium.listeners.TestListener;
import com.jforce.selenium.pageObject.TableOfContentPageObject;
import com.jforce.selenium.service.UserService;
import com.jforce.selenium.testdata.TutorialProductionTestData;

import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;

@Epic("TOC:PEJ-255")
@TmsLink("TMS-004")
@Listeners(TestListener.class)
public class UniversityAdmin extends Common {

    @Autowired private WaitActions waitActions;
    @Autowired private TableOfContentPageObject tableOfContentPageObject;

    @Override
    protected String getRoleForTest() {
        return "BU_UNIVERSITY_ADMIN";
    }

    @Test(testName = "Verify 'Planning Schedules' table headers in Tutorial Production")
    public void verifyPlanningScheduleTableHeaders() {
                        tableOfContentPageObject.navigateToTutorialProduction();
                        tableOfContentPageObject.clickOnPlanningSchedulesTab();
                        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
                        tableOfContentPageObject.expectedFieldName(
                                TutorialProductionTestData.EXPECTED_HEADERS_FOR_PLANING,
                                TableOfContentElements.DATA_TABLE_HEADERS
                        );
                    }

    @Test(testName = "Verify 'Admin Approval' table headers in Tutorial Production")
    public void verifyAdminApprovalTableHeaders() {
                        tableOfContentPageObject.navigateToTutorialProduction();
                        tableOfContentPageObject.clickOnAdminApprovalTab();
                        waitActions.waitForTableRows(TableOfContentElements.DATA_TABLE_HEADERS);
                        tableOfContentPageObject.expectedFieldName(
                                TutorialProductionTestData.EXPECTED_HEADERS_FOR_ADMIN_APPROVAL,
                                TableOfContentElements.DATA_TABLE_HEADERS
                        );
                    }
}
