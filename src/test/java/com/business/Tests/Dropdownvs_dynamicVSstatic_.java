package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdownvs_dynamicVSstatic_ extends Base {

    @Test
    public void checkDropdowns() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        // How many elements in dropdown list
        System.out.println("Dropdown elements size is -> " + select.getOptions().size());
        // Get options by name
        List<WebElement> optionsList = select.getOptions();
        System.out.println("All options are below :");
        for (WebElement option : optionsList) {
            System.out.println(option.getText());
        }
        // Get default selected option by default
        System.out.println("By default selected in dropdown - > " + select.getFirstSelectedOption().getText());
        // Select another option
        select.selectByVisibleText("Option 1");
        // Verify Option 1 selected
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
    }

    /**
     * Note : If we work with calendar type elements such as airline dropdowns
     * from and to  tables then we have to understand the second tab is exact copy of first table,
     * that is why when we locate any element in to , second tab we have to use below syntax:
     * <p>
     * (//a[@value='DEL'])[2]  -> (base xpath inside parentheses) [2] ,index 2 means in second table
     */
    @Test
    public void dynamicDropdownCalendarType() {
        extentLogger=report.createTest("DynamicDropDownCalendarType Tesing");
            driver.get("https://www.spicejet.com/");
            driver.findElement(By.cssSelector("input[value='RoundTrip']")).click();
            WebElement from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
            from.click();
            WebElement fromCity = driver.findElement(By.xpath("//a[@value='MAA']"));
            fromCity.click();
            System.out.println(from.getAttribute("value"));
            Assert.assertTrue(from.getAttribute("value").equalsIgnoreCase("Chennai (MAA)"));
            WebElement to = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
            to.click();
            WebElement toCity = driver.findElement(By.xpath("(//a[@value='DEL'])[2]"));
            toCity.click();
            System.out.println(to.getAttribute("value"));
            extentLogger.info("Verify the data");
            Assert.assertTrue(to.getAttribute("value").equalsIgnoreCase("Delhi (DEL)"));
//            WebElement currentDay = driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight ui-state-active')]"));
//            actions.moveToElement(currentDay).click().build().perform();
        }
    }



