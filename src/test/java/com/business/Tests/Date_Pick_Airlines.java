package com.business.Tests;

import com.business.Utilities.Base;
import com.business.Utilities.JSUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Date_Pick_Airlines extends Base {

    @Test
    public void path2US() throws InterruptedException {
        extentLogger = extentReports.createTest("Path2USE23");
        driver.get("https://www.path2usa.com/travel-companions");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement from = driver.findElement(By.id("travel_from"));
        from.sendKeys("Arkansas");
        Thread.sleep(700);
        //from.sendKeys(Keys.DOWN);
        from.sendKeys(Keys.ENTER); // will point 1st option
        Assert.assertEquals(from.getAttribute("value"), "Northwest Arkansas Regional Airport (XNA) Fayetteville");
        WebElement to = driver.findElement(By.id("travel_to"));
        to.sendKeys("JFK");
        Thread.sleep(700);
        // to.sendKeys(Keys.DOWN);
        to.sendKeys(Keys.ENTER); // will point 1st option
        Assert.assertTrue(to.getAttribute("value").contains("John F. Kennedy International Airport"));
        //Choose July 15
        WebElement travelDate = driver.findElement(By.id("travel_date"));
        travelDate.click();
        WebElement month = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']"));
        WebElement next = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'»')]"));
        // click next until getting July
        while (!month.getText().contains("July")) {
            next.click();
        }
        // store all days in List, iterate and click 15
        List<WebElement> days = driver.findElements(By.xpath("//td[@class='day']"));
        for (WebElement day : days) {
            if (day.getText().contains("15")) {
                day.click();
                break;
            }
        }
        Thread.sleep(1000);
        // Verify date selected correctly
        Assert.assertTrue(travelDate.getAttribute("value").contains("07-15"));
        //Select dropdown from static dropdown
        WebElement weeks = driver.findElement(By.id("datebetween"));
        Select selectWeek = new Select(weeks);
        selectWeek.selectByVisibleText("+ - 2 Weeks");
        Assert.assertEquals(selectWeek.getFirstSelectedOption().getText(), "+ - 2 Weeks");
        WebElement airLine = driver.findElement(By.id("travel_airline"));
        Select selectAirline = new Select(airLine);
        selectAirline.selectByVisibleText("Air Canada");
        Assert.assertEquals(selectAirline.getFirstSelectedOption().getText(), "Air Canada");
        WebElement language = driver.findElement(By.id("travel_language"));
        Select selectLanguage = new Select(language);
        selectLanguage.selectByVisibleText("English");
        Assert.assertEquals(selectLanguage.getFirstSelectedOption().getText(), "English");
        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(text(),'SEARCH')]"));
        // searchBtn.click(); --> ElementClickInterceptedException:
        JSUtil.clickElementByJS(searchBtn, driver);
        //Assert.assertTrue(driver.getPageSource().contains("Travel Companions"));


    }
}

