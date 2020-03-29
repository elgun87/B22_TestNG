package com.business.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Locators {

    @Test
    public void usingLocators() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cargurus.com/");
        WebElement carMakeDropdown = driver.findElement(By.id("carPickerUsed_makerSelect"));
        Select selectMake = new Select(carMakeDropdown);
        selectMake.selectByVisibleText("Audi");
        WebElement carModelDropdown = driver.findElement(By.id("carPickerUsed_modelSelect"));
        Select selectModel = new Select(carModelDropdown);
        selectModel.selectByVisibleText("Q7");
        driver.findElement(By.id("dealFinderZipUsedId_dealFinderForm")).sendKeys("72713");
        driver.findElement(By.id("dealFinderForm_0")).click();
        Thread.sleep(1000);
        driver.close();
        driver.quit();

    }

}
