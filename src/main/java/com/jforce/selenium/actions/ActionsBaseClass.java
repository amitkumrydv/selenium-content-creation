package com.jforce.selenium.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.jforce.selenium.config.SeleniumProperties;


@Component
public class ActionsBaseClass {

	@Autowired
	@Lazy // to start browser only on script execution
	public WebDriver driver;

	@Autowired
	@Lazy
	public WebDriverWait webDriverWait;

	@Autowired
	public ApplicationContext applicationContext;

	@Autowired
	public SeleniumProperties seleniumProperties;
	
	@Autowired
	public UtilityClass utilityClass;


	
	

}
