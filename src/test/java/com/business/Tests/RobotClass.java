package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RobotClass extends Base {

    @Test
    public void downloadWithRobot() throws AWTException {
        extentLogger = extentReports.createTest("download With Robot Class");
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement file = driver.findElement(By.linkText("test.txt"));
        file.click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        String fileName = "test.txt";
        String path = "C:\\Users\\salma\\Downloads\\" + fileName;
        //important
        Assert.assertTrue(Files.exists(Paths.get(path)));

    }
}
