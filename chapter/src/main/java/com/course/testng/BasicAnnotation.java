package com.course.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAnnotation {

    @Test
    public void testCase1(){
        System.out.println("this is the testcase1111!!!");
    }

    @Test
    public void testCase2(){
        System.out.println("this is the testcase2222!!!");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("this is the BeforeMethod!!!");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("this is the AfterMethod!!!");
    }
}
