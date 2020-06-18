package com.business.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public abstract class Base {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions actions;

    private static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentLogger;
    protected Pages pages;


    @BeforeTest(alwaysRun = true)
    public void setupTest() {
        String filePath = System.getProperty("user.dir") + "\\test-output\\extentReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentHtmlReporter.config().setReportName("Automated Test Reports"); // name of report
        extentHtmlReporter.config().setDocumentTitle("Test Results"); // title of report
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Environment", "QA_1");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("QA Engineer", "Anar Salmanov");

    }


    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = DriverUtil.getDriver();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
        softAssert = new SoftAssert();
        actions = new Actions(driver);
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
        extentReports.flush();
        DriverUtil.closeDriver();
    }


}