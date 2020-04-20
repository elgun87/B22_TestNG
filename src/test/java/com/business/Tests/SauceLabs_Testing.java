package com.business.Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class SauceLabs_Testing {
    /**
     * 2 steps to run our tests in SauceLabs/Any ready Selenium Grid
     * --> 1) Create DesiredCapabilities object and specify what type of OS and Browser you want to run in.
     * --> 2) Create RemoteWebDriver with HUB url and caps object;
     */


    private WebDriver driver;
    public static final String SAUCELABS_URL = "https://Anar013:7d1692a4-3808-4747-96da-2a2d6b18c217@ondemand.saucelabs.com:443/wd/hub";

    @Test(enabled = false)
    public void buttonClicking() throws MalformedURLException {
        // 1 step -Setting DesiredCapabilities
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setPlatform(Platform.WIN10);
        caps.setCapability("version", "latest");
        driver = new RemoteWebDriver(new URL(SAUCELABS_URL), caps);
        // 2  step  -Initializing driver
        driver.get("https://www.etsy.com");
        WebElement searchbox = driver.findElement(By.id("global-enhancements-search-query"));
        searchbox.sendKeys("Wooden spoon" + Keys.ENTER);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("wooden spoon"));
    }
}
