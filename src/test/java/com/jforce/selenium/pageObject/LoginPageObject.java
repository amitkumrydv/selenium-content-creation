package com.jforce.selenium.pageObject;

import com.jforce.selenium.actions.ElementActions;
import com.jforce.selenium.common.CommonPageObject;
import com.jforce.selenium.elements.LoginElements;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Component
public class LoginPageObject extends CommonPageObject {

    @Autowired
    private ElementActions uiElements;

    @Step("Open Login Page")
    public void openLoginPage() {
        iUIElements.openURL(seleniumProperties.getLoginUrl());
    }

    @Step("Enter credentials: username={0}, password=******")
    public void enterCredentials(String username, String password) {
        uiElements.sendKeys(LoginElements.USERNAME_INPUT, username);
        uiElements.sendKeys(LoginElements.PASSWORD_INPUT, password);
    }

    @Step("Click on Login Button")
    public void clickLoginButton() {
        uiElements.click(LoginElements.LOGIN_BUTTON, "Login button");
    }
    
    @Step("Click on LogOUT Button")
    public void clickLogoutButton() throws InterruptedException {
    	uiElements.click(LoginElements.LOGOUT_BUTTON, "Logout button");
    	Thread.sleep(2000);
    }
    
    
    @Step("Login page verify")
    public void loginPageVerify() {
    	
    	boolean ElementVisiblity=uiElements.isDisplayElement(LoginElements.LOGIN_FORM);
    	Assert.assertTrue(ElementVisiblity, "Login form is not displayed on the page!");
    	
    }
    
    
    

    @Step("Get page title")
    public String getPageTitle() {
        return iElementVerification.getTitle();
    }
}
