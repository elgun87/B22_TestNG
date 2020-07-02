package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Popup_HTML extends Base {

    @Test
    public void htmlPopup() throws InterruptedException {
        extentLogger = extentReports.createTest("HTML Popup verify");
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.cssSelector(".ui-button-text.ui-c")).click();
        WebElement alertbox = driver.findElement(By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-check']"));
        alertbox.click();
        Thread.sleep(2000);
    }

}
