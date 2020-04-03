package com.business.Tests;

import org.openqa.selenium.By;
import com.business.Utilities.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Windows_Handling extends Base {

    @Test
    public void handle_Windows() {
        extentLogger = report.createTest("Window handling test");
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentTitle = driver.getTitle();
        extentLogger.info("click 3 windows");
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.linkText("Click Here")).click();
        }
        extentLogger.info("Store all clicked windows");
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        extentLogger.info("Initilize the parent window");
        String parentWindow = it.next();
        extentLogger.info("Iterate other windows and handle all windows, switch driver to each ot them and get titles");
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getWindowHandle());   // Will print 3 new windows (not main window)
            System.out.println(driver.getTitle());
        }
        extentLogger.info("Switch back to parent window");
        driver.switchTo().window(parentWindow);
        System.out.println("Parent window" + parentWindow);
        extentLogger.info("Verify driver switched to parent window and titles are matching.");
        Assert.assertEquals(parentTitle, driver.getTitle());
        extentLogger.pass("window handlimg test");


    }


}
