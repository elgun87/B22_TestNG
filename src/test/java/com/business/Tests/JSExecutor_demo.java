package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.Alert;
import org.testng.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JSExecutor_demo extends Base {

    @Test
    public void createAnAlert() throws InterruptedException {
        extentLogger = report.createTest("Creating JS alert");
        extentLogger.info("Navigate to website");
        driver.get("https://www.guru99.com/execute-javascript-selenium-webdriver.html");
        extentLogger.info("Wait until the JS alert visible");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('hello');");
        Thread.sleep(2000);
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            extentLogger.info("Alert created and handled");
        } catch (Exception e) {
             e.printStackTrace();
        }
    }


}









