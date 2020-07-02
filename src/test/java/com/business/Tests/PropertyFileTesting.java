package com.business.Tests;

import com.business.Utilities.Base;
import com.business.Utilities.ConfigReader;
import org.testng.annotations.Test;


public class PropertyFileTesting extends Base {

    @Test
    public void testPropertyFile() {
        extentLogger = extentReports.createTest("Reading data from property file");
        driver.get(ConfigReader.getProperty("url"));
        pages.homepage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));


    }

}
