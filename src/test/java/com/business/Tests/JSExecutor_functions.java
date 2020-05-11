package com.business.Tests;

import com.business.Utilities.Base;
import com.business.Utilities.JSUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutor_functions extends Base {


    @Test
    public void flashingTheElement() throws InterruptedException {
        extentLogger = report.createTest("JSExecutor functions testing");
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dropDown = driver.findElement(By.linkText("Dropdown"));
        extentLogger.info("Flashing the element");
        JSUtil.flashElement(dropDown, driver);
        WebElement dynamicContent = driver.findElement(By.linkText("Dynamic Content"));
        extentLogger.info("Drawing the border for element");
        JSUtil.drawBorder(dynamicContent, driver);
        Thread.sleep(2000);
        extentLogger.info("Getting title with JS executor");
        String title = JSUtil.getTitleOfPageByJS(driver);
        System.out.println(title);
        extentLogger.info("Clicking element with JS executor");
        JSUtil.clickElementByJS(dynamicContent, driver);
        extentLogger.info("Using JS executor creating JS alert message in the page after certain operation");
        JSUtil.generateJSAlert(driver, "You have clicked the Dynamic Elements link");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        extentLogger.info("Refreshing the page with JS executor");
        JSUtil.refreshPageByJS(driver);
    }


}
