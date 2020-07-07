package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;

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


    @Test
    public void verifyFileExistInDownloadedFolder() throws AWTException, InterruptedException {
        extentLogger = extentReports.createTest("Verifying file downloaded to our machine");
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement file = driver.findElement(By.linkText("text.txt"));
        File filePath = new File(System.getProperty("user.dir") + "/text.txt");
        if (!filePath.exists()) {
            file.click();
        }
        Thread.sleep(2000);
        Assert.assertTrue(filePath.exists());
    }


}
