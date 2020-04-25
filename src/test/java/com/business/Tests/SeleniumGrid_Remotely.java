package com.business.Tests;

import junit.runner.Version;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid_Remotely {

    /**
     * 2 steps to run our tests in SauceLabs/Any ready Selenium Grid
     * > 1) Set ChromeOptions
     * > 2) Create RemoteWebDriver with HUB url and caps object;
     */


    private WebDriver driver;

    @Test
    public void buttonClicking() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        driver = new RemoteWebDriver(new URL("http://192.168.0.86:4444/wd/hub"), options);

        driver.get("https://www.etsy.com");
        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("Wooden spoon" + Keys.ENTER);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("wooden spoon"));
        driver.quit();
    }

}
