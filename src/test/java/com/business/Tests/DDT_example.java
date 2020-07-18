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
    String path = "src/test/resources/login.xlsx"; // internally in method uses FileInputStream
    ExcelUtil excelUtil = new ExcelUtil(path, "details");


    @DataProvider(name = "loginData")
    public Object[][] testData() {
        Object[][] detailsFromExcel = excelUtil.getDataArray();
        return detailsFromExcel;
    }

    @Test(dataProvider = "loginData")
    public void dataDrivenTest(String username, String password, String result) throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/login");
        WebElement usernameBox = driver.findElement(By.id("username"));

        usernameBox.sendKeys(username);
        Thread.sleep(1000);
        WebElement passwordBox = driver.findElement(By.id("password"));

        passwordBox.sendKeys(password);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//i[text()=' Login']")).click();
        Thread.sleep(1000);
        WebElement resultField = driver.findElement(By.xpath("//div[@id='flash']"));
        BrowserUtil.waitForVisibility(resultField);
        String resultText = resultField.getText();
        System.out.println(resultText);

        Assert.assertTrue(resultText.contains(result));
    }


}
