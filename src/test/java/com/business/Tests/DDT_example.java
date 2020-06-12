package com.business.Tests;

import com.business.Utilities.Base;
import com.business.Utilities.BrowserUtil;
import com.business.Utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT_example extends Base {

    // create object of ExcelUtil and pass path and sheet name to its constructor.
    String path = "src/test/resources/login.xlsx";
    ExcelUtil excelUtil = new ExcelUtil(path, "details");


    @DataProvider(name = "loginData")
    public Object[][] testData() {
        Object[][] detailsFromExcel = excelUtil.getDataArray();
        return detailsFromExcel;
    }

    @Test(dataProvider = "loginData")
    public void dataDrivenTest(String username, String password, String result) throws InterruptedException {
        extentLogger = extentReports.createTest("Data Driven Test");
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement usernameBox = driver.findElement(By.id("username"));
        extentLogger.info("Passing username");
        usernameBox.sendKeys(username);
        Thread.sleep(1000);
        WebElement passwordBox = driver.findElement(By.id("password"));
        extentLogger.info("Passing password");
        passwordBox.sendKeys(password);
        Thread.sleep(1000);
        extentLogger.info("Clicking login button");
        driver.findElement(By.xpath("//i[text()=' Login']")).click();
        Thread.sleep(1000);
        WebElement resultField = driver.findElement(By.xpath("//div[@id='flash']"));
        BrowserUtil.waitFor_Visibility(resultField);
        String resultText = resultField.getText();
        System.out.println(resultText);
        extentLogger.info("Verifying the welcome text");
        Assert.assertTrue(resultText.contains(result));
    }


}
