package com.business.Tests;

import org.testng.annotations.Test;

public class OrderOfTests {

    @Test(priority=0)
    public void test1() {
        System.out.println("Executing 1");
    }


    @Test(priority=1)
    public void test2() {
        System.out.println("Executing 2");

    }


    @Test(priority =2)
    public void test3() {
        System.out.println("Executing 3");

    }
}
