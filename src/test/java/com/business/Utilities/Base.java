package com.business.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public abstract class Base {

    private static Logger log = LogManager.getLogger(Base.class.getName());

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions actions;

//    protected static ExtentSparkReporter extentSparkReporter;
//    protected static ExtentReports extentReports;
//    protected static ExtentTest extentLogger;
    protected Pages pages;


   // @BeforeTest(alwaysRun = true)
//    public void setupTest() {
//        String filePath = System.getProperty("user.dir") + "\\test-output\\ExtentReport.html";
//        extentSparkReporter = new ExtentSparkReporter(filePath);
//        extentSparkReporter.config().setReportName("Automated Test Reports"); // name of report
//        extentSparkReporter.config().setDocumentTitle("Test Results"); // title of report
//        extentSparkReporter.config().setTheme(Theme.DARK);
//        extentReports = new ExtentReports();
//        extentReports.attachReporter(extentSparkReporter);
//        extentReports.setSystemInfo("Environment", "QA_1");
//        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
//        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
//        extentReports.setSystemInfo("QA Engineer", "Anar Salmanov");
//
//    }


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
  public void teardown (ITestResult result) {
      softAssert.assertAll();
      if (result.getStatus() == ITestResult.FAILURE) {
          //Using this method if I run my tests in class level not with maven
          String screenshotLocation = BrowserUtil.getScreenshotPath(result.getName());
          DriverUtil.closeDriver();
          log.info("browser closed");
      }

  }}