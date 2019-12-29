package com.course.cases;

import com.course.config.TestConfig;
import com.course.utils.databaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserListTest {

    @Test(dependsOnGroups = "LoginTrue",description = "获取用户列表")
    public void getUserInfoListTest() throws IOException{
        SqlSession session = databaseUtil.getSqlsession();
        GetUserListTest getUserInfoListCase = session.selectOne("getUserInfoListCase",1);
        System.out.println(getUserInfoListCase.toString());
        System.out.println(TestConfig.getUserListUrl);
    }
}
