package com.business.Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

public class BrowserUtils {


    public static String getScreenshot(String name) {
        String time = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverUtil.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "\\test-output\\screenshot_" + name + time + ".png";
        File finalDestination = new File(target);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException io) {
        }
        return target;
    }


    public static void waitFor_Visibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitFor_In_Visible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            try {
                element.isDisplayed();
                break;
            } catch (StaleElementReferenceException st) {
                y++;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }

    public static void fluentWait(WebElement webElement) {
        Wait wait = new FluentWait<>(DriverUtil.getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(800))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class);
        WebElement element = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> webElement);
        try {
            element.click();
        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
