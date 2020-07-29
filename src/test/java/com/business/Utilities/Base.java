package com.business.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public abstract class Base {

    private static final Logger log = LogManager.getLogger(Base.class.getName());

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions actions;
    protected Pages pages;


    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = DriverUtil.getDriver();
        log.info(ConfigReader.getProperty("browser") + " launched");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
        actions = new Actions(driver);
        pages = new Pages();
    }


    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {
        softAssert.assertAll();
        if (result.getStatus() == ITestResult.FAILURE) {
            // will get screenshot if test fails
            BrowserUtil.getScreenshotPath(result.getName());
            DriverUtil.closeDriver();
            log.info("browser closed");
        }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        DriverUtil.quitDriver();
    }

}