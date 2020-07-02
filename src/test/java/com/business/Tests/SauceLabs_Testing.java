package com.business.Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
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


    @Test(enabled = false)
    public void buttonClicking() throws MalformedURLException {
        // sauceLabs account url
        URL url = new URL("https://anar1986:" +
                "d49bdf28-ea00-4d0d-81fa-ee7be578238e@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        //1 step -Setting DesiredCapabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.WINDOWS);
        caps.setBrowserName("Chrome");
        caps.setCapability("version", "latest");
        // 2. Initialize driver
        driver = new RemoteWebDriver(url, caps);
        driver.get("https://www.etsy.com");
        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("Wooden spoon" + Keys.ENTER);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("wooden spoon"));
    }
}
