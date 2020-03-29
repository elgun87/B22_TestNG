package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class JS_Popup extends Base {

    @Test
    public void JS_popupTesting() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().getText();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
    }
}
