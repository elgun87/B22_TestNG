package com.business.Tests;

import com.business.Utilities.Base;
import com.business.Utilities.BrowserUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Parallel_CrossBrowser extends Base {

    private static Logger log = LogManager.getLogger(Parallel_CrossBrowser.class.getName());

    @Parameters({"browser"})
    @Test(groups = "smoke")
    public void doubleClick_RightClick(String browserName) {
        extentLogger = extentReports.createTest("Double click on element");
        driver.get("https://www.amazon.com/");
        String mainTitle = driver.getTitle();
        // Do double click to element
        WebElement nextSign = driver.findElement(By.xpath("//i[@class='a-icon a-icon-next-rounded']"));
        actions.moveToElement(nextSign).doubleClick().build().perform();
        // Do right click
        WebElement searchEditbox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.moveToElement(searchEditbox).contextClick().build().perform();
        searchEditbox.click();
        // Move to specific element
        WebElement customerService = driver.findElement(By.xpath("//a[contains(text(),'Customer Service')]"));
        actions.moveToElement(customerService).click().build().perform();
        String cstmrTitle = driver.getTitle();
        extentLogger.info("Verifying th result");
        Assert.assertFalse(mainTitle.equalsIgnoreCase(cstmrTitle));

    }


    /**
     * Here we use KEYS for down/up
     */
    @Test
    public void mouseHover_MoveToElement() {
        extentLogger = extentReports.createTest("Mouse hover test");
        driver.get("https://www.amazon.com/");
        WebElement prime = driver.findElement(By.xpath("//span[contains(text(),'Try Prime')]"));
        extentLogger.info("Verifying the result");
        actions.moveToElement(prime).build().perform();
    }

    @Test
    public void scrollDown_scrollUP() throws InterruptedException {
        extentLogger = extentReports.createTest("Scroll up and down");
        driver.get("https://www.airtelxstream.in/");
        int i = 0;
        int j = 0;
        while (i < 300) {
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            i++;
        }
        Thread.sleep(2000);
        while (j < 300) {
            actions.sendKeys(Keys.PAGE_UP).build().perform();
            j++;
        }

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        extentLogger = extentReports.createTest("Drag and drop testing");
        driver.get("https://jqueryui.com/droppable/");
        log.info("navigated to website");
        Thread.sleep(5000);
        WebElement mainFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(mainFrame);
        log.info("switching to the frame");
        extentLogger.info("Verifying the result");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
        Thread.sleep(2000);
        log.info("dragging the element and dropping to drop field");
        WebElement dropConfirmTextField = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        BrowserUtil.waitForVisibility(dropConfirmTextField);
        log.info("waiting for confirmation text to be visible");
        Assert.assertTrue(dropConfirmTextField.isDisplayed());
        log.info("element dropped ");

    }

    @Test
    public void sendTextInUppercase() throws InterruptedException {
        extentLogger = extentReports.createTest("Sending text in Uppercase");
        log.info("navigating the amazon.com");
        driver.get("https://www.amazon.com/");
        WebElement editBox = driver.findElement(By.id("twotabsearchtextbox"));
        log.info("entering text in Upeercase");
        actions.keyDown(editBox, Keys.SHIFT).sendKeys("hello").build().perform();
        Thread.sleep(2000);
        log.info("Verifying text added in Upeercase");
        Assert.assertEquals(editBox.getAttribute("value"), "HELLO");
        log.info("text passed in Uppercase");
    }
}


