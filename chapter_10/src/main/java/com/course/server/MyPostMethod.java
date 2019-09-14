package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我的全部post请求")
@RequestMapping(value = "/v1")
public class MyPostMethod {

    private static Cookie cookie;

    //用户登录成功获取到cookies，然后再访问其他接口获取到列表

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息！login interface ,get cookies after login success!",httpMethod = "post")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "passWord",required = true) String passWord){
        if (userName.equals("zhangsan")&&passWord.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登录成功！";
        }
        return "用户名或密码错误！";

    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "post")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User user){
        User user1;
        //获取cookies
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies
             ) {
            if (cookie.getName().equals("login")
                    && cookie.getValue().equals("true")
                    && user.getUserName().equals("zhangsan")
                    && user.getPassWord().equals("123456")){
                user1 = new User();
                user1.setName("huangyu");
                user1.setAge("24");
                user1.setSex("man");
                return user1.toString();
            }
        }return "参数不合法！！";

    }

}
