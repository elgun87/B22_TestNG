package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxes extends Base {
    /**
     * go to : http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
     * <p>
     * select on monday only if it is not select
     */
    @Test
    public void checkBoxTesting() {

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        WebElement monday = driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-input"));

        Assert.assertFalse(monday.isSelected());
        monday.click();
        Assert.assertTrue(monday.isSelected());
    }

}
