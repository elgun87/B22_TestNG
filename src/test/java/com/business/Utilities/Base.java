package com.business.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public abstract class Base {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    public WebDriverWait wait;
    protected Actions actions;
    protected static ExtentReports report;
    private static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;
    protected Pages pages;


    @BeforeTest(alwaysRun = true)
    public void setupTest() {
        report = new ExtentReports();
        String filePath = System.getProperty("user.dir") + "\\test-output\\ExtentReport.html";
        htmlReporter = new ExtentHtmlReporter(filePath);
        report.attachReporter(htmlReporter);
        report.setSystemInfo("Environment", "Staging");
        report.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("QA Engineer", "Anar Salmanov");
        htmlReporter.config().setDocumentTitle("Test Results");
        htmlReporter.config().setReportName("Automated Test Reports");
    }


    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        report.flush();
    }


    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = DriverUtil.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 30);
        pages = new Pages();

    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) throws IOException {
        softAssert.assertAll();
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotLocation = BrowserUtil.getScreenshot(result.getName());
            extentLogger.fail(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            extentLogger.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentLogger.skip("Test case skipped " + result.getName());
        }
        DriverUtil.closeDriver();
    }


    @AfterClass(alwaysRun = true)
    public void quit() {
        DriverUtil.closeDriver();

    }
}