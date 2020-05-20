package com.business.Tests;


import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SortAlphabetical extends Base {


    @Test
    public void verifyOptionsAreAlphaBetichal() {
        driver.get("https://www.amazon.com/");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select selectDropdown = new Select(dropdown);
        List<WebElement> list = selectDropdown.getOptions();
        String current = "";
        String next = "";
        for (int i = 0; i < list.size() - 1; i++) {
            current = list.get(i).getText();
            next = list.get(i + 1).getText();
            System.out.println(list.get(i).getText());
        }
        Assert.assertTrue(current.compareTo(next) < 0);

    }
}

