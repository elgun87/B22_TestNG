package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;

public class FileUpload_verify extends Base {
    /**
     * --  FILE UPLOADING --
     * We have to store the full path of the to be uploaded document.
     * In website we don't click the upload button and choose the document to upload,
     * We just locate the element(element must have INPUT tag), dont click on that just
     * using sendKeys method and putting the path of the document.
     * Then ve can verify any notification message in website to verify the document
     * uploaded.
     */


    @Test
    public void file_Uploaded_Verify() {
        extentLogger = extentReports.createTest("Verifying file upload to element having input tag");
        driver.get("https://the-internet.herokuapp.com/upload");
        String fileName = "test.txt";
        String filePath = "C:\\Users\\salma\\Downloads\\" + fileName;
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));
        chooseFile.sendKeys(filePath);
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]")).getText().contains("File Uploaded!"));


    }


    @Test
    public void drag_Drop_file_Uploaded_Verify() {
        extentLogger = extentReports.createTest("Verifying file upload by drag and drop using JS executor");
        driver.get("https://the-internet.herokuapp.com/upload");
        String fileName = "test.txt";
        String path = "C:\\Users\\salma\\Downloads\\" + fileName;
        WebElement target = driver.findElement(By.id("drag-drop-upload"));
        DropFile(new File(path), target, 0, 0);
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Internal Server Error')]")).getText().contains("Internal Server Error"));



    }


    private static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
        if (!filePath.exists())
            throw new WebDriverException("File not found: " + filePath.toString());
        WebDriver driver = ((RemoteWebElement) target).getWrappedDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.style.display = 'none';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "" +
                        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";
        WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
        input.sendKeys(filePath.getAbsoluteFile().toString());
        wait.until(ExpectedConditions.stalenessOf(input));
    }

}
