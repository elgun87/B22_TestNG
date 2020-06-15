package com.business.Tests;


import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortAlphabetical extends Base {


    @Test(enabled = false)
    public void verifyOptionsAreAlphaBethical() {
        extentLogger = extentReports.createTest("Verify dropdown elements are in asc order ");
        extentLogger.info("navigating the website");
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        extentLogger.info("Locating the dropdown");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        extentLogger.info("Storing all WebElements in the List");
        Select selectDropdown = new Select(dropdown);
        List<WebElement> optionsList = selectDropdown.getOptions();
        extentLogger.info("Creating new ArrayList,Iterating WebElements List to get the names of options and " +
                "storing the names of options in that ArrayList");
        ArrayList<String> originalList = new ArrayList<>();
        for (WebElement option : optionsList) {
            originalList.add(option.getText());
        }
        extentLogger.info("Creating another Arraylist from list of option names");
        ArrayList<String> copiedList = new ArrayList<>(originalList);
        extentLogger.info("Sorting second Arraylist");
        Collections.sort(copiedList);
        extentLogger.info("Comparing original list with sorted list");
        Assert.assertEquals(originalList, copiedList); //-> Logic is correct, but the list in website is not
        // in ascending order
    }

    @Test
    public void verifyCellsInTableAreSorted() throws InterruptedException {
        extentLogger = extentReports.createTest("Testing elements in table column are in asc order");
        extentLogger.info("Navigating the website");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        WebElement header = driver.findElement(By.xpath("//b[contains(text(),'Veg/fruit name')]"));
        header.click();
        header.click();
        extentLogger.info("Storing all WebElements of Column2 in the list");
        List<WebElement> column_1st = driver.findElements(By.xpath("//table[@id='sortableTable']//tbody//tr//td[2]"));
        extentLogger.info("Creating new ArrayList,Iterating WebElements List to get the names of options and " +
                "storing the names of options in that ArrayList");
        ArrayList<String> originalList = new ArrayList<>();
        for (int i = 0; i < column_1st.size(); i++) {
            originalList.add(column_1st.get(i).getText());
        }
        extentLogger.info("Creating another Arraylist from list of option names");
        ArrayList<String> copiedList = new ArrayList<>(originalList);
        extentLogger.info("Sorting second Arraylist");
        Collections.sort(copiedList);
        extentLogger.info("Comparing original list with sorted list");
        Assert.assertEquals(originalList, copiedList);
        extentLogger.info("Test passed");

    }

}

