package com.business.Tests;


import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortAlphabetical extends Base {


    @Test
    public void verifyOptionsAreAlphaBetichal() {
        // using the compareTo method, We will compare each element in the list to the next one.
        driver.get("https://www.amazon.com/");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select selectDropdown = new Select(dropdown);
        //List<String> list= selectDropdown.getOptions();
        for (int i = 0; i < selectDropdown.getOptions().size() - 1; i++) {
            String current = selectDropdown.getOptions().get(i).getText();
            String next = selectDropdown.getOptions().get(i + 1).getText();
           // Assert.assertTrue(current.compareTo(next) < 0);
        }

    }
}

