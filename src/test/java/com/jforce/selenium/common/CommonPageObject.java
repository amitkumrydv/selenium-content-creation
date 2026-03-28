package com.jforce.selenium.common;

import static java.util.Objects.nonNull;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jforce.selenium.actions.ActionsBaseClass;
import com.jforce.selenium.interfaces.IElementVerification;
import com.jforce.selenium.interfaces.IExplicitWait;
import com.jforce.selenium.interfaces.IJavaScriptActions;
import com.jforce.selenium.interfaces.IUIElements;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@Scope("driverscope")
public class CommonPageObject extends ActionsBaseClass {

	@Autowired
	public IUIElements iUIElements;

	@Autowired
	public IElementVerification iElementVerification;

	@Autowired
	public IExplicitWait iExplicitWait;

	@Autowired
	public IJavaScriptActions iJavaScriptActions;

	public void teardownDriver() {
		log.info("Taking Screenshots");
		attachScreenShot();
		log.info("Closing Browsers");
//		if (nonNull(driver)) {
//			driver.close();
//		}
	}

	@Attachment(value = "Screen shot", type = "image/png", fileExtension = ".png")
	public byte[] attachScreenShot() {
		try {
			return ((TakesScreenshot) applicationContext.getBean(WebDriver.class)).getScreenshotAs(OutputType.BYTES);
		} catch (WebDriverException e) {
			log.error("Selenium screenshot capture failed: {}", e.getMessage());
		}
		return new byte[0];
	}

}
