package com.business.Tests;

import com.business.Utilities.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Popup_JS_with_Lof4J extends Base {
    //must be created for eah class
    private static Logger log = LogManager.getLogger(Popup_JS_with_Lof4J.class.getName());

    @Test
    public void JS_popupTesting() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        log.info("navigated the website");
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        log.info("clicked text generating JS popup");
        Thread.sleep(2000);
        String alertText = driver.switchTo().alert().getText();
        log.info("alert presents,alert text is: " + alertText);
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        log.info("alert presents,alert dismissed");

    }
}
