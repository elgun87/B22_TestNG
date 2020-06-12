package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dropdown_Dynamic extends Base {


    /**
     * Note : If we work with dropdowns which one appears only after
     * selecting value in previous dropdowns (as airline dropdowns (not dates) )
     * from and to tables then we have to understand the second tab is exact copy of first table,
     * to locate second element we have to use below syntax:
     * (//a[@value='DEL'])[2]  -> (base xpath inside parentheses) [2] ,index 2 means in second table
     */

    @Test
    public void dynamicDropdownCalendarType() {
        extentLogger = extentReports.createTest("DynamicDropDown Testing");
        driver.get("https://www.spicejet.com");
        driver.findElement(By.cssSelector("input[value='RoundTrip']")).click();
        WebElement from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        from.click();
        WebElement fromCity = driver.findElement(By.xpath("//a[@value='MAA']"));
        fromCity.click();
        System.out.println(from.getAttribute("value"));
        Assert.assertTrue(from.getAttribute("value").equalsIgnoreCase("Chennai (MAA)"));
        WebElement to = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
        to.click();                // pay attention !
        WebElement toCity = driver.findElement(By.xpath("(//a[@value='DEL'])[2]"));
        toCity.click();
        System.out.println(to.getAttribute("value"));
        extentLogger.info("Verify the data");
        Assert.assertTrue(to.getAttribute("value").equalsIgnoreCase("Delhi (DEL)"));

        // or for each table we can use //parent //child xpath (space in the middle)
        //driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

    }
}



