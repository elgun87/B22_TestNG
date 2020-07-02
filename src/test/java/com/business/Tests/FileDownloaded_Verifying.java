package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloaded_Verifying extends Base {

    /**
     * --  FILE DOWNLOADING --
     * Selenium cannot automate Windows_Handling Based actions:
     * We must use Robot class to be able to click save in the Windows system.
     * Verify whether specific file downloaded to our computer or not.
     * We get the file name from the website and using that and our download folder we create a path.
     * Then using Files class in Java library we can verify after clicking the download button,
     * the specific file downloaded to our downloads folder and it exists there
     */


    @Test(enabled = false)
    public void verifyFileExistInDownloadedFolder() throws AWTException {
        extentLogger = extentReports.createTest("Verifying file downloaded to our machine");
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement file = driver.findElement(By.linkText("text.txt"));
        file.click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        String fileName = "text.txt";
        String path = "C:\\Users\\salma\\Downloads\\" + fileName;
        Assert.assertTrue(Files.exists(Paths.get(path)));
    }


}
