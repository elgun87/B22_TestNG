package com.business.Tests;


import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Button extends Base {

    @Test
    public void buttonClicking() {
        driver.get("https://www.etsy.com/");
        WebElement searchbox = driver.findElement(By.id("global-enhancements-search-query"));
        searchbox.sendKeys("Wooden spoon");
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
        Assert.assertEquals(driver.findElement(By.id("global-enhancements-search-query")).getAttribute("value"), "Wooden spoon");
    }
}
