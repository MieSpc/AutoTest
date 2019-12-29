package com.course.cases;

import com.course.config.TestConfig;
import com.course.utils.databaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue",description = "添加用户")
    public void testAddUser() throws IOException{
        SqlSession session = databaseUtil.getSqlsession();
        AddUserTest addUserCase = session.selectOne("addUserCase",1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);
    }
}
