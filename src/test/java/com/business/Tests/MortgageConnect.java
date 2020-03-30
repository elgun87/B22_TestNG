package com.business.Tests;

import com.business.Utilities.Base;
import com.business.Utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MortgageConnect extends Base {

    @Test
    public void getAllLingsInDocumentAndPrintsSolution() throws InterruptedException {
        extentLogger = report.createTest("Mortgage connection");
        extentLogger.info("Navigating to website");
        driver.get("https://www2.mortgageconnectlp.com/");
        WebElement dcAndPrint = driver.findElement(By.xpath("//span[contains(text(),'Document & Print Solutions')]"));
        extentLogger.info("Moving to dropdown");
        actions.moveToElement(dcAndPrint).build().perform();
        extentLogger.info("Clicking the item :Document Generation");
        WebElement menuBar = driver.findElement(By.xpath("//li[4]//ul[1]"));
        List<WebElement> allLinks = menuBar.findElements(By.tagName("a"));
        WebElement docGeneratemyLink = null;
        for (WebElement link : allLinks) {
            if (link.getText().contains("Document Generation")) {
                docGeneratemyLink = link;
            }
        }
        BrowserUtils.waitForStaleElement(docGeneratemyLink);
        docGeneratemyLink.click();
        System.out.println(driver.getTitle());
        extentLogger.info("Verifying the title of new page");
        Assert.assertTrue(driver.getTitle().contains("Document Generation"));

    }


}
