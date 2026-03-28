package com.jforce.selenium.listeners;


import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.jforce.selenium.config.DriverManager;

import java.io.ByteArrayInputStream;

@Slf4j
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("Test Started: {}", iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test Passed: {}", iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.warn("Test Skipped: {}", iTestResult.getName());
        captureScreenshot("Skipped Screenshot");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error("Test Failed: {} - {}", iTestResult.getName(), iTestResult.getThrowable());
        captureScreenshot("Failure Screenshot");
    }

    private void captureScreenshot(String title) {
        log.debug("Attempting to capture screenshot: {}", title);
        WebDriver driver = DriverManager.getDriver();

        if (driver == null) {
            log.warn("WebDriver is null. Cannot take screenshot.");
            return;
        }

        try {
            String pageTitle = driver.getTitle();
            String currentUrl = driver.getCurrentUrl();

            log.debug("Page Title: {}", pageTitle);
            log.debug("Page URL: {}", currentUrl);

            attachText("Page Title", pageTitle);
            attachText("Page URL", currentUrl);

            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            log.debug("Screenshot captured. Byte size: {}", screenshotBytes.length);

            attachScreenshotToAllure(title, screenshotBytes);

        } catch (Exception e) {
            log.error("Exception while capturing screenshot: {}", e.getMessage(), e);
        }
    }

    @Attachment(value = "{name}", type = "image/png")
    private byte[] attachScreenshotToAllure(String name, byte[] bytes) {
        if (bytes != null && bytes.length > 0) {
            Allure.addAttachment(name, new ByteArrayInputStream(bytes));
            log.info("Screenshot attached to Allure: {}", name);
        } else {
            log.warn("No screenshot captured for attachment: {}", name);
            Allure.step("No screenshot captured (empty byte array)");
        }
        return bytes;
    }

    @Attachment(value = "{name}", type = "text/plain")
    private String attachText(String name, String value) {
        log.info("Attaching text to Allure: {} = {}", name, value);
        return value;
    }
}
