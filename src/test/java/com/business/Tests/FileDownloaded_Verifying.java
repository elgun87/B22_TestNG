package com.business.Tests;

import com.business.Utilities.Base;
import com.business.Utilities.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    public void verifyFileExistInProjectDirectory() {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement file = driver.findElement(By.linkText("text.txt"));
        //store in File object in the project with name to be loaded file
        File filePath = new File(System.getProperty("user.dir") + "/text.txt");
        if (!filePath.exists()) {
            file.click();
        }
        BrowserUtil.wait(1);
        Assert.assertTrue(filePath.exists()); // Used to verify weather any file exist or not.
    }


}
