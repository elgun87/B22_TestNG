package com.business.Tests;

import com.business.Pages.HomePage;
import com.business.Utilities.Base;
import com.business.Utilities.ConfigurationReader;
import org.testng.annotations.Test;


public class PropertyFileTesting extends Base {

    @Test
    public void testPropertyFile() {
        driver.get(ConfigurationReader.getProperty("url"));
        pages.homepage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));


    }

}
