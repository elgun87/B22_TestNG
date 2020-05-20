package com.business.Tests;

import com.business.Utilities.Base;
import com.business.Utilities.JSUtil;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class Dropdown_Autosuggestive extends Base {

    @Test
    public void autoSuggestiveDropdown() throws InterruptedException {
        extentLogger = report.createTest("Autosuggestive Dropdown");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.makemytrip.com/");
        WebElement from = driver.findElement(By.id("fromCity"));
        WebElement to = driver.findElement(By.id("toCity"));
        from.sendKeys("Del");
        Thread.sleep(1000);
        from.sendKeys(Keys.ARROW_DOWN); // will point to 2nd option, because default points to 1st
        from.sendKeys(Keys.ARROW_DOWN); // will point to 3rd optionD
        from.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        to.sendKeys("Baku");
        Thread.sleep(2000);
        for (int i = 0; i < 3; i++) {
            to.sendKeys(Keys.ARROW_DOWN); //will loop 3 times , then will point to 4th option
        }
        to.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }


}
