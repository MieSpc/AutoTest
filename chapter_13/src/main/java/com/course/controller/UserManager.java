package com.course.controller;

import com.course.modul.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Log4j2
@RestController
@Api(value = "v1",description = "UserManager Service")
@RequestMapping("v1")
public class UserManager {

    @Autowired
    private SqlSessionTemplate template;

    @ApiOperation(value = "login interface",httpMethod = "POST")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Boolean login(HttpServletResponse response , @RequestBody User user){
        int i = template.selectOne("login",user);
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        log.info("select result is:"+i);
        if (i==1){
            log.info("login user is:"+user.getUser_name());
            return true;
        }
        return false;
    }

    @ApiOperation(value = "addUser interface",httpMethod = "POST")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public boolean addUser(HttpServletRequest request,@RequestBody User user){
        Boolean verify = verifyCookies(request);
        int result = 0;
        if (verify!=null){
            result = template.insert("addUser",user);
        }
        if (result> 0){
            log.info("add user count:"+result);
            return true;
        }
        return false;
    }

    @ApiOperation(value = "getUserInfo/List interface",httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public List<User> getUserInfo(HttpServletRequest request,@RequestBody User user){
        Boolean verify = verifyCookies(request);
        if (verify==true){
            List<User> userList = template.selectList("getUserInfo",user);
            log.info("get user count:"+userList.size());
            return userList;
        }
        return null;
    }

    @ApiOperation(value = "updateUserInfo interface",httpMethod = "POST")
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public int updateUserInfo(HttpServletRequest request,@RequestBody User user){
        Boolean verify = verifyCookies(request);
        int updateCount = 0;
        if (verify==true){
            updateCount = template.update("updateUserInfo",user);
        }
        log.info("updateUserCount:"+updateCount);
        return updateCount;
    }

    private Boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            log.info("cookies is null");
            return false;
        }
        for (Cookie cookie:cookies
             ) {
            if (cookie.getName().equals("login") &&
                    cookie.getValue().equals("true")){
                log.info("cookies verify pass");
                return true;
            }
        }
        return false;
    }
}
