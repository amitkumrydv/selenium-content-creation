package com.jforce.selenium.common;


import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.jforce.selenium.actions.WaitActions;
import com.jforce.selenium.config.AuthrizationToken;
import com.jforce.selenium.entity.UserEntity;
import com.jforce.selenium.listeners.TestListener;
import com.jforce.selenium.pageObject.LoginPageObject;
import com.jforce.selenium.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(properties = {"spring.profiles.active=test"})
@Listeners(TestListener.class)
public abstract class Common extends AbstractTestNGSpringContextTests {

    @Autowired protected WaitActions waitActions;
    @Autowired protected LoginPageObject loginPage;
    @Autowired private UserService userService;
    @Autowired private AuthrizationToken authrizationToken;
    @Autowired private CommonPageObject commonPageObject;
    

    
    

    protected abstract String getRoleForTest();
    protected String accessToken;

    @BeforeClass
    public void loginOnce() throws InterruptedException, JSONException {

        if (accessToken == null) {
            log.info("Access token is null → Performing fresh login for role: {}", getRoleForTest());
            String role = getRoleForTest();
            UserEntity user = userService.getUserByRole(role);
            if (user == null) {
                throw new RuntimeException("No user found for role: " + role);
            }

            loginAs(user.getEmail(), user.getPassword());
            Thread.sleep(4000);
            accessToken = authrizationToken.getAccessToken();
            log.info("New access token acquired and stored.");
        } else {
            log.info("Reusing existing access token.");
            authrizationToken.setAccessToken(accessToken);
        }
    }

    
    public void loginAs(String username, String password) throws InterruptedException, JSONException {
        log.debug("Logging in with user: {}", username);
        loginPage.openLoginPage();
        loginPage.enterCredentials(username, password);
        loginPage.clickLoginButton();
        
        
    }
    

    @AfterSuite
    public void logout() throws InterruptedException {
        log.info("Logging out of the application...");
        loginPage.clickLogoutButton();
        loginPage.loginPageVerify();
        log.info("Logout completed.");
    }
}
