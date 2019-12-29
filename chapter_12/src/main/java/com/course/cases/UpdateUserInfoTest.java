package com.course.cases;

import com.course.config.TestConfig;
import com.course.utils.databaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserInfoTest {

    @Test(dependsOnGroups = "LonginTrue",description = "更新用户信息")
    public void testUpdateUserInfo() throws IOException {
        SqlSession session = databaseUtil.getSqlsession();
        UpdateUserInfoTest updateUserInfoTest = session.selectOne("UpdateUserInfo",1);
        System.out.println(updateUserInfoTest.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
    }

    @Test(dependsOnGroups = "LonginTrue",description = "删除用户信息")
    public void testDeletUser () throws IOException {
        SqlSession session = databaseUtil.getSqlsession();
        UpdateUserInfoTest updateUserInfoTest = session.selectOne("UpdateUserInfo",2);
        System.out.println(updateUserInfoTest.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
    }
}
