package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我的全部get方法")
public class MyGetMethod {

    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies",httpMethod = "get")
    public String getCookies(HttpServletResponse response){

        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);

        //HttpSeverletRequest
        return "恭喜你获取cookies信息成功！！！";
    }

    /*
    * 要求客户端携带cookies访问
    *
    * */

    @ApiOperation(value = "这个方法要求客户端携带cookies访问",httpMethod = "get")
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){

        //多个key-value cookies的数组
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "你必须携带cookies信息来！！！";
        }
        for (Cookie cookie:cookies
             ) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "这是一个需要携带cookies信息才能访问的get请求！！！";
            }
        }
        return "你必须携带cookies信息来！！！";
    }

    /**
     * 开发一个需要携带参数才能访问的请求
     * 第一种实现方式  url：key=value&key=value
     * 模拟获取商品列表
     * */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "这个是需要携带参数才能访问的请求一",httpMethod = "get")
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end ){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("iPhone8",5999);
        myList.put("iPhone8Plus",7999);
        myList.put("iPhoneXR",9999);
        return myList;
    }

    /**
     * 第二种实现方式
     * url:ip:port/get/with/param
     * */
    @RequestMapping(value = "get/with/param/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "这个是需要携带参数才能访问的请求二",httpMethod = "get")
    public Map<String,Integer> myGetList(@PathVariable Integer start,
                                         @PathVariable Integer end){
    Map<String,Integer> myList = new HashMap<>();
        myList.put("iwatch1",3999);
        myList.put("iwatch2",5999);
        myList.put("iwatch3",7999);
        return myList;
    }

}
