package com.jforce.selenium.elements;

import org.openqa.selenium.By;

import com.jforce.selenium.common.CommonPageObject;

public class LoginElements{
    public static final By USERNAME_INPUT = By.name("username");
    public static final By PASSWORD_INPUT = By.name("password");
    public static final By LOGIN_BUTTON = By.xpath("//button[@type=\"submit\"]");
    public static final By LOGOUT_BUTTON = By.xpath("//button[text()='Logout']");
    public static final By LOGIN_FORM = By.xpath("//form[@action='/auth/login']");
    
    
}
