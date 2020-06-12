package com.business.Tests;

import com.business.Utilities.Base;
import com.business.Utilities.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidating extends Base {
    /**
     * Go to automation practice , provide wrong
     */


    @Test
    public void wrongEmailAndPasswordTest() {
        // create a new test in the report and give name : Wrong email and assword testing
        extentLogger = extentReports.createTest("Wrong email and Password testing");
        // use the logger to log the steps
        extentLogger.info("Navigating The website");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        //using page objects
        extentLogger.info("entering username");
        pages.homepage.username.sendKeys(ConfigReader.getProperty("username"));
        extentLogger.info("entering password");
        pages.homepage.passWord.sendKeys(ConfigReader.getProperty("password"));
        extentLogger.info("clicking submit button");
        pages.homepage.submitBtn.click();
        // using the method which created from  page objects
        pages.homepage.login("zorayde", "xosemi");
        extentLogger.info("Validating the error message");
        String errorMessage = driver.findElement(By.id("ctl00_MainContent_status")).getText();
        Assert.assertEquals(errorMessage, "Invalid Login or Password.");
        extentLogger.pass("Wrong email and password");
    }

    @Test
    public void verifyBlankUsrNamme() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        pages.homepage.login("", "xosemi");
        String errorMessage = driver.findElement(By.id("ctl00_MainContent_status")).getText();
        Assert.assertEquals(errorMessage, "Invalid Login or Password.");
    }


}
