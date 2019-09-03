package com.course.testng;

import org.testng.annotations.Test;


/*
* 忽略测试！
* */
public class IgnoreTest {

    @Test
    public void Ignore1(){
        System.out.println("ignore1 running!!!!");
    }

    @Test(enabled = false)
    public void Ignore2(){
        System.out.println("ignore2 running!!!!");
    }

    @Test(enabled = true)
    public void Ignore3(){
        System.out.println("ignore3 running!!!!");
    }

}
