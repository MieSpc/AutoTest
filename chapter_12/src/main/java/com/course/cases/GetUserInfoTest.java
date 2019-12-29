package com.course.cases;

import com.course.config.TestConfig;
import com.course.utils.databaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserInfoTest {

    @Test(dependsOnGroups = "LonginTrue",description = "获取用户信息")
    public void getUserINfoTest()throws IOException {
        SqlSession session = databaseUtil.getSqlsession();
        GetUserInfoTest getUserInfoCase = session.selectOne("getUserInfoCase",1);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);
    }
}
