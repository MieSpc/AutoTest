package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void dataProvider(String name, int age) {
        System.out.println("name = " + name + ", age = " + age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] obj = new Object[][]{
                {"zhangsan", 10},
                {"lisi", 20},
                {"wangwu", 30}
        };
        return obj;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name, int age) {
        System.out.println("test1 || name = " + name + ", age = " + age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name, int age) {
        System.out.println("test2 || name = " + name + ", age = " + age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataprovider(Method method) {
        Object[][] result = null;

        if (method.getName().equals("test1")) {
            result = new Object[][]{
                    {"zhangsna", 20},
                    {"lisi", 22}
            };
        } else if (method.getName().equals("test2")) {
            result = new Object[][]{
                    {"wangwu",50},
                    {"zhaoliu",60}
            };
        }
        return result;
}
}
