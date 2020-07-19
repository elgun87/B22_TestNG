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

    @Test(groups = {"regression"})
    public void spiceJetE2E() throws InterruptedException {
        driver.get("https://www.spicejet.com");
        // Select round trip
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        // Verify after click radio btn is selected
        Thread.sleep(1000);
        WebElement familyCheckBox = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
        //Verify Student checkbox not selected
        Assert.assertFalse(familyCheckBox.isSelected());
        familyCheckBox.click();
        //Verify after clicking on it Student checkbox is selected
        Assert.assertTrue(familyCheckBox.isSelected());
        // Choose from and to locations
        WebElement from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        JSUtil.clickElementByJS(from);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),' Kolkata (CCU)')]")).click();
        BrowserUtil.wait(1000);
        //Dynamically put inside parentheses and show [2] -> in table 2
        driver.findElement(By.xpath("(//a[@value='PAT'])[2]")).click();
        Thread.sleep(1000);
        //Choose current date as from date
        driver.findElement(By.xpath("//td[contains(@class,'ui-datepicker-current-day ui-datepicker-today')]//a")).click();
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
        JSUtil.clickElementByJS(totalPassengers);
        BrowserUtil.wait(2000);
        // choose adults and verify
        WebElement adultsDropdown = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
        Select selectAdults = new Select(adultsDropdown);
        selectAdults.selectByVisibleText("2");
        Assert.assertEquals(selectAdults.getFirstSelectedOption().getText(), "2");
        // choose children and verify
        WebElement childDropdown = driver.findElement(By.id("ctl00_mainContent_ddl_Child"));
        Select selectChild = new Select(childDropdown);
        selectChild.selectByVisibleText("2");
        Assert.assertEquals(selectChild.getFirstSelectedOption().getText(), "2");
        // Verify total passengers are 2 Adults 2 Child
        JSUtil.clickElementByJS(totalPassengers);
        Assert.assertEquals(totalPassengers.getText(), "2 Adult, 2 Child");
    }
}
