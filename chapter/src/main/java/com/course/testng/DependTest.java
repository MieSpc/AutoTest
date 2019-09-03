package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {

    @Test(expectedExceptions = RuntimeException.class)
    public void test1(){
        System.out.println("yilaiceshi !!!!!!!!");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("success!!!!");
    }

    @Test
    public void test3(){
        System.out.println("yilaiceshi !!!!!!!!");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test3"})
    public void test4(){
        System.out.println("success!!!!");
    }
}
