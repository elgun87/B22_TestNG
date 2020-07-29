package com.business.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtil {
    /**
     * Reason of using this class is avoid using extent report object in each test
     * This class will connected to Listener class and in test execution it will generate reports automatically.
     */
    public static ExtentReports extentReports;

    public static ExtentReports extentReportGenerator() {
        String filePath = System.getProperty("user.dir") + "\\test-output\\ExtentReport.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filePath);
        extentSparkReporter.config().setReportName("Web Automation Result");
        extentSparkReporter.config().setDocumentTitle("Test Results");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Environment", "QA_1");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("QA Engineer", "Anar Salmanov");
        return extentReports;
    }


}
