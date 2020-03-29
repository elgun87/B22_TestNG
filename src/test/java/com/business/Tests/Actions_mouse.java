package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Actions_mouse extends Base {

    @Test
    public void doubleClick_RightClick() {
        extentLogger = report.createTest("Dpuble click on element");
        driver.get("https://www.amazon.com/");
        String maintTitle = driver.getTitle();
        // Do double click to element
        WebElement nextSign = driver.findElement(By.xpath("//i[@class='a-icon a-icon-next-rounded']"));
        actions.doubleClick(nextSign).build().perform();
        // Do right click
        WebElement searchEditbox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.contextClick(searchEditbox).build().perform();
        searchEditbox.click();
        // Move to specific element
        WebElement customerService = driver.findElement(By.xpath("//a[contains(text(),'Customer Service')]"));
        actions.moveToElement(customerService).click().build().perform();
        String cstmrTitle = driver.getTitle();
        Assert.assertFalse(maintTitle.equalsIgnoreCase(cstmrTitle));

    }


    /**
     * Here we use KEYS for down/up
     */
    @Test
    public void mouseHower_MoveToElement() {

        extentLogger = report.createTest("Mouse hover test");
        driver.get("https://www.amazon.com/");
        WebElement prime = driver.findElement(By.xpath("//span[contains(text(),'Try Prime')]"));
        actions.moveToElement(prime).build().perform();
    }

    @Test
    public void scroolDown_scroolUP() {

        extentLogger = report.createTest("Scrrol up amd down");
        driver.get("https://www.youtube.com/");
        int i = 0;
        int j = 0;
        while (i < 3) {
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            i++;
        }
        while (j < 3) {
            actions.sendKeys(Keys.PAGE_UP).build().perform();
            j++;
        }

    }

    @Test
    public void dragAndDrop() {
        extentLogger = report.createTest("Drag and drop testing");
        driver.get("https://jqueryui.com/droppable/");
        WebElement mainFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(mainFrame);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

    }
}


