package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/*
*
* */
public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite running!!!!");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite running!!!!");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforetest running!!!!");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("aftertest running!!!!");
    }
}
