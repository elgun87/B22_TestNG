package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Here we combine WebElements based on their common class name,
 * then iterate and click whatever we want click.
 */

public class Dropdown_BootStrap extends Base {

    @Test

    public void bootstrapDropdown() throws InterruptedException {
        extentLogger = extentReports.createTest("NoSelectTagDropDown");
        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(3000);
        driver.findElement(By.id("dropdownMenuLink")).click(); //to expand dropdown
        //<a class="dropdown-item" href="https://www.amazon.com/">Amazon</a>
        Thread.sleep(3000);
        //store all elements of dropdown in 1 list
        List<WebElement> allLinks = driver.findElements(By.xpath("a[@class='dropdown-item']"));
        // loop the list , get text and value of attributes from each element
        for (WebElement link : allLinks) {
            System.out.println(link.getText() + " : " + link.getAttribute("href"));
        }
        extentLogger.info("Verify the links");
        driver.findElement(By.linkText("Etsy")).click();//click on option
        Thread.sleep(1000);


    }


}
