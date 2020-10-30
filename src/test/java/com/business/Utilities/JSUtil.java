package com.business.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtil {

    public static void flashElement(WebElement element, WebDriver driver) {
        String bgColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 8; i++) {
            changeColor("#000000", element, driver);
            changeColor(bgColor, element, driver);
        }
    }

    private static void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        BrowserUtil.wait(1);

    }

    public static void drawBorder(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static String getTitleOfPageByJS() {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        return js.executeScript("return document.title;").toString();
    }

    public static void clickElementByJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static void generateJSAlert(String message) {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        js.executeScript("alert('" + message + "')");
    }

    public static void refreshPageByJS() {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        js.executeScript("history.go(0)");
    }

    public static WebElement getShadowRoot(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        return (WebElement) js.executeScript("return arguments[0].shadowRoot", element);
    }

}
