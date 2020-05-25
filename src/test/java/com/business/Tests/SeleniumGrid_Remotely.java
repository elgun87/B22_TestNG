package com.business.Tests;

import junit.runner.Version;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid_Remotely {

    /**
     * 2 steps to run our tests in SauceLabs/Any ready Selenium Grid
     * > 1) Set ChromeOptions, DesiredCapabilities
     * > 2) Create RemoteWebDriver with HUB url and caps object;
     */

    String gridHubUrl ="http://localhost:4444/wd/hub";

    @Test
    public void buttonClicking() throws MalformedURLException {
//        ChromeOptions options = new ChromeOptions();
//        options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
//        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
//        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.WINDOWS);
        desiredCapabilities.setBrowserName("Chrome");
        WebDriver driver = new RemoteWebDriver(new URL(gridHubUrl), desiredCapabilities);
        driver.get("https://www.etsy.com");
        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("Wooden spoon" + Keys.ENTER);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("wooden spoon"));
        driver.quit();
    }

}
