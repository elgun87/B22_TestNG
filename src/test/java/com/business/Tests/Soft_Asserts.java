package com.business.Tests;


import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Soft_Asserts  extends Base {
    /** Go to google
     * Search for Selenium coockbook
     * verify title contains the search term
     */

    @Test

    public void verifySearchTerm () {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium cookbook" + Keys.ENTER);
        String title = driver.getTitle();
        System.out.println(title);
        //Softassert - we make fail the validation to make sure it will not terminate the flow
        //We nitilized the object in Base class .
        softAssert.assertTrue(title.contains("Selenium cookbook"));
        //At the end of code we have to  use this line if we use softAssert in our code
        //If test fails it will not stop the test but will report at the end of test.



    }


}
