package com.business.Tests;


import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Iframes extends Base {

    @Test
    public void iFrameTesting() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/tinymce");
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement editbox = driver.findElement(By.xpath("//p[contains(text(),'Your content goes here.')]"));
        editbox.clear();
        Thread.sleep(2000);
        editbox.sendKeys("I love Java");
        Thread.sleep(1000);
        /*
              ---  FIND HOW MANY FRAMES IN THIS PAGE ---
         */
        List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
        int size =  frameList.size();
        System.out.println(driver.findElements(By.tagName("iframe")).size());




    }


}
