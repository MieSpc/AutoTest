package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {

    public void stu1(){
        System.out.println("GroupsOnClass22222中的stu1111111运行了");
    }

    public void stu2(){
        System.out.println("GroupsOnClass22222中的stu2222222运行了");
    }
}
