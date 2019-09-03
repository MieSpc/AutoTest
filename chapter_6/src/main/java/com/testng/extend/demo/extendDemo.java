package com.testng.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class extendDemo {


    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void logDemo(){
        Reporter.log("this is log by myselef");
        throw new RuntimeException("this is exception by myselef!!!!");

    }
}
