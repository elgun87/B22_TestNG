package com.business.Tests;

import com.business.Utilities.Base;
import com.business.Utilities.BrowserUtil;
import com.business.Utilities.JSUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SpiceJet_E2E extends Base {

    @Test(enabled = true)
    public void spiceJetE2E() throws InterruptedException {
        extentLogger = extentReports.createTest("SpiceJet");
        driver.get("https://www.spicejet.com");
        // Select round trip
        driver.findElement(By.xpath("//table[@id='ctl00_mainContent_rbtnl_Trip']//td[2]//input")).click();
        // Verify after click radio btn is selected
        WebElement studentCheckBox = driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount"));
        //Verify Student checkbox not selected
        Assert.assertFalse(studentCheckBox.isSelected());
        studentCheckBox.click();
        //Verify after clicking on it Student checkbox is selected
        Assert.assertTrue(studentCheckBox.isSelected());
        // Choose from and to locations
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@text='Kolkata (CCU)']")).click();
        BrowserUtil.sleep(1000);
        //Dynamically put inside parentises and show [2] -> in table 2
        driver.findElement(By.xpath("(//a[@value='PAT'])[2]")).click();
        Thread.sleep(1000);
        //Choose current date as from date
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default ui-state-highlight ui-state-active']")).click();
        //Choose returning date
        driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
        // Locate table
        // Locate all days from table_2 in 1 List and choose date 13
        WebElement table = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//table"));
        List<WebElement> allColumns = table.findElements(By.xpath("//tbody//tr//td"));
        for (WebElement day : allColumns) {
            if (day.getText().contains("13")) {
                day.click();
                break;
            }
        }
        // Choose passengers
        WebElement totalPassengers = driver.findElement(By.id("divpaxinfo"));
        JSUtil.clickElementByJS(totalPassengers, driver);
        BrowserUtil.sleep(2000);
        // choose adults
        WebElement adultsDropdown = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
        Select selectAdults = new Select(adultsDropdown);
        selectAdults.selectByVisibleText("2");
        //Verify you selected 2 adults from Adult dropdown
        Assert.assertEquals(selectAdults.getFirstSelectedOption().getText(), "2");
        // choose children
        WebElement childDropdown = driver.findElement(By.id("ctl00_mainContent_ddl_Child"));
        Select selectChild = new Select(childDropdown);
        selectChild.selectByVisibleText("2");
        //Verify you selected 2 adults from Child dropdown
        Assert.assertEquals(selectChild.getFirstSelectedOption().getText(), "2");
        // Verify total passengers are 2 Adults 2 Child
        Assert.assertEquals(totalPassengers.getText(), "2 Adult, 2 Child");

    }
}
