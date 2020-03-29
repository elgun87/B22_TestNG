package com.business.Tests;

import org.openqa.selenium.By;
import com.business.Utilities.Base;
import org.testng.annotations.Test;

import java.util.Set;

public class Windows extends Base {

    @Test

    public void handleWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println("Homepage title :" + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String> windows = driver.getWindowHandles();

        //Iterate the windows, switch them and get titles, and come back to parent window
        for (String window : windows) {
            System.out.println(window);
            System.out.println(driver.switchTo().window(window).getTitle());
        }




    }


}
