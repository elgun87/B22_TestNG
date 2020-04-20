package com.business.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * We use Singleton design pattern in order to have one browser instance at the same time
 * We will make DriverUtil class constructor private. In our tests 1st line we will call DriverUtil.getDriver,
 * getDriver() method in DriverUtil class will initialize value driver object.
 */

public class DriverUtil {

    private static WebDriver driver;

    private DriverUtil() {
    }


    public static WebDriver getDriver() {
        if (driver == null) {
            if (ConfigReader.getProperty("browser").equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (ConfigReader.getProperty("browser").equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (ConfigReader.getProperty("browser").equalsIgnoreCase("ie")) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            } else if (ConfigReader.getProperty("browser").equalsIgnoreCase("chrome-headless")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
            }

        }
        return driver;
    }


    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
