package com.business.Tests;

import com.business.Utilities.Base;
import org.testng.annotations.Test;

import java.io.IOException;

public class Selenium4_Invoke_Multiple_Tabs extends Base {

    /*
    Scenario ; Go to https://rahulshettyacademy.com/angularpractice/"
    in name field add 1st course name from  https://rahulshettyacademy.com
     */
    @Test
    public void invokeMultipleWindows() throws InterruptedException, IOException {
//        driver.get("https://rahulshettyacademy.com/angularpractice/");
//        WebElement editbox = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
//        // Open new URL in another Tab
//        driver.switchTo().newWindow(WindowType.TAB);
//        Thread.sleep(1000);
//        // Driver still points to 1st window, handle all open windows and switch to next window
//        Set<String> windows = driver.getWindowHandles();
//        Iterator<String> it = windows.iterator();
//        String parentWindow = it.next(); // points current parent window
//        String childWindow = it.next(); // must be declared after parent window, will point next child window
//        driver.switchTo().window(childWindow);
//        driver.get("https://rahulshettyacademy.com");
//        List<WebElement> courses = driver.findElements(By.xpath("//h2//a"));
//        String courseName = courses.get(0).getText();
//        driver.switchTo().window(parentWindow);
//        editbox.sendKeys(courseName);
//        Thread.sleep(2000);
//        // Taking Screenshot of WebElement
//        File file = editbox.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(file, new File("editbox.png"));
//        // Get Height and Width of element
//        int height = editbox.getRect().getDimension().getHeight();
//        int width = editbox.getRect().getDimension().getWidth();
//        System.out.println("height : " + height + ", width : " + width);

    }

}
