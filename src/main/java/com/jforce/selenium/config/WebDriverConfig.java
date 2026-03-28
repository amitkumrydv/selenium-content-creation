package com.jforce.selenium.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.testng.annotations.AfterSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class WebDriverConfig {

    @Autowired
    private SeleniumProperties seleniumProperties;

    private WebDriver driver;
    
    
    
    @Bean
    @Scope("driverscope")
    WebDriver webDriver() throws MalformedURLException {
        WebDriver driver;
        
        if (seleniumProperties.isGrid()) {
            driver = createRemoteWebDriver();
        } else {
            driver = createLocalWebDriver();
        }

        // 👇 Register the driver in ThreadLocal
        DriverManager.setDriver(driver);

        this.driver = driver; // For cleanup
        return driver;
    }


//    @Bean
//    @Scope("driverscope")
//    WebDriver webDriver() throws MalformedURLException {
//        if (seleniumProperties.isGrid()) {
//            this.driver = createRemoteWebDriver();
//        } else {
//            this.driver = createLocalWebDriver();
//        }
//        return this.driver;
//    }

    @Bean
    @Scope("driverscope")
    WebDriverWait webDriverWait(WebDriver webDriver) {
        log.debug("Building WebDriverWait with timeout: {}", seleniumProperties.getExplicitTimeout());
        return new WebDriverWait(webDriver, seleniumProperties.getExplicitTimeout());
    }

    @PreDestroy
    public void cleanup() {
        if (driver != null) {
            log.info("Quitting WebDriver");
            try {
                driver.quit();
            } catch (Exception e) {
                log.warn("Error while quitting WebDriver: {}", e.getMessage());
            }
        }
    }

    private WebDriver createLocalWebDriver() {
        String browser = seleniumProperties.getBrowser().toLowerCase();

        switch (browser) {
            case "chrome":
                return initChromeDriver();
            case "firefox":
                return initFirefoxDriver();
            case "edge":
                return initEdgeDriver();
            case "safari":
                return initSafariDriver();
            default:
                log.warn("Unsupported or unspecified browser '{}'. Falling back to Chrome.", browser);
                return initChromeDriver();
        }
    }

    private WebDriver createRemoteWebDriver() throws MalformedURLException {
        log.info("Creating RemoteWebDriver for Grid. Browser: {}, URL: {}",
                seleniumProperties.getBrowser(), seleniumProperties.getGridUrl());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(seleniumProperties.getBrowser());
        capabilities.setCapability("e34:token", seleniumProperties.getGridToken());

        RemoteWebDriver remoteDriver = new RemoteWebDriver(new URL(seleniumProperties.getGridUrl()), capabilities);
        remoteDriver.setFileDetector(new LocalFileDetector());

        return remoteDriver;
    }

    private WebDriver initChromeDriver() {
        log.info("Initializing ChromeDriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        
        // Disable Pop-ups and redirects
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.popups", 1);
        prefs.put("profile.default_content_setting_values.redirects", 1);
        
        options.addArguments("--remote-debugging-port=9222", "--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notification");
        options.setExperimentalOption("prefs", prefs);

        if (seleniumProperties.isHeadless()) {
            options.addArguments("--headless=new");
            log.debug("Chrome headless mode enabled");
        }

        return maximize(new ChromeDriver(options));
    }

    private WebDriver initFirefoxDriver() {
        log.info("Initializing FirefoxDriver");
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();

        if (seleniumProperties.isHeadless()) {
            options.addArguments("-headless");
            log.debug("Firefox headless mode enabled");
        }

        return maximize(new FirefoxDriver(options));
    }

    private WebDriver initEdgeDriver() {
        log.info("Initializing EdgeDriver");
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");

        if (seleniumProperties.isHeadless()) {
            options.addArguments("--headless=new");
            log.debug("Edge headless mode enabled");
        }

        return maximize(new EdgeDriver(options));
    }

    private WebDriver initSafariDriver() {
        log.info("Initializing SafariDriver");
        // Safari does NOT support headless mode currently
        return maximize(new SafariDriver());
    }

    private WebDriver maximize(WebDriver driver) {
        driver.manage().window().maximize();
        log.debug("{} window maximized", driver.getClass().getSimpleName());
        return driver;
    }
    
    
   
    
    
    @AfterSuite
    public void quitBrowser() {
    	driver.quit();
    }
}
