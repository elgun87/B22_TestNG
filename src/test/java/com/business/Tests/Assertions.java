package com.business.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;


/***
 * Use the assertions that comes from testNag
 */
public class Assertions {

    @Test    // Verify they are equal
    public void verifyEqual() {
        String fruit1 = "apple";
        String fruit2 = "apple";
        Assert.assertEquals(fruit1, fruit2);
    }

    @Test
    public void verifyDifferent() {
        String name1 = " Anar";
        String name2 = "Nazi";
        Assert.assertNotEquals(name1, name2);
    }


}
