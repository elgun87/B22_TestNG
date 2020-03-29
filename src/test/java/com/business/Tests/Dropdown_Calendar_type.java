package com.business.Tests;

import com.business.Utilities.Base;
import com.business.Utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdown_Calendar_type extends Base {


    @Test
    //I want to select day 14 May in the calendar
    public void calendarElementSelecting() throws InterruptedException {
        driver.get("https://www.path2usa.com/travel-companions");
        // try to pick date 14
        // 1. locate from date edit-box
        WebElement fromEditbox = driver.findElement(By.xpath("//input[@name='travel_date']"));
        fromEditbox.click();
        // 1.Locate next button
        WebElement nextArrow = driver.findElement(By.xpath("//th[@class='next']"));
        // 2. Store Month
        WebElement month = driver.findElement(By.xpath("//th[@class='datepicker-switch']"));
        // loop while month will become May
        while (!month.getText().contains("May")) {
            nextArrow.click();
        }
        //Verify month is May
        Assert.assertTrue(month.getText().contains("May"));
        //className day  common for each day in from date table Store all days in one list
        List<WebElement> days = driver.findElements(By.className("day"));
        int count = days.size();
        // Loop all days and click which contains 14
        for (WebElement day : days) {
            String dayText = day.getText();
            if (dayText.equalsIgnoreCase("14")) {
                day.click();
                // wait until edit-box value changed after clicking
                wait.until(ExpectedConditions.attributeContains(fromEditbox, "value", "14"));
                break;
            }
        }
        // verify edit-box value changed
        Assert.assertTrue(fromEditbox.getAttribute("value").contains("14"));


    }


}