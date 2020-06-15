package com.business.Tests;


import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Button extends Base {

    @Test
    public void buttonClicking() {
        driver.get("https://www.etsy.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("Wooden spoon");
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
        Assert.assertEquals(driver.findElement(By.id("global-enhancements-search-query")).getAttribute("value"), "Wooden spoon");
    }
}
