package com.jforce.selenium.validations;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EpubReaderValidator {

    private WebDriver driver;
    private WebDriverWait wait;

    public EpubReaderValidator(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean isReaderLoaded() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector(".loader, .spinner")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isContentVisible() {
        try {
            String text = driver.findElement(By.tagName("body")).getText();
            return text != null && text.length() > 50;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNavigationWorking() {
        try {
            WebElement nextBtn = driver.findElement(By.cssSelector(".next-page, .nav-next"));
            String before = driver.findElement(By.tagName("body")).getText();

            nextBtn.click();
            Thread.sleep(1500);

            String after = driver.findElement(By.tagName("body")).getText();
            return !before.equals(after);

        } catch (Exception e) {
            return false;
        }
    }
}
