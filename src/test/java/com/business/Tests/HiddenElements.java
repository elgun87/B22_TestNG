package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HiddenElements extends Base {

    @Test

    public void verifyTesxtDisappeader() {
        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");
        WebElement textFrame = driver.findElement(By.id("myDIV"));
        Assert.assertTrue(textFrame.isDisplayed());
        driver.findElement(By.xpath("//button[contains(text(),'Toggle Hide and Show')]")).click();
        Assert.assertFalse(textFrame.isDisplayed());
    }
}
