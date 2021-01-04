package com.example.demo.controller;

import com.example.demo.entity.R;
import com.example.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: gq
 * @createtime: 2020/12/8 14:35
 * @description: post方法集合
 */
@RestController
//@ApiIgnore
@RequestMapping(value = "/v1")
@Api(value = "/", tags= {"post方法集合"})

public class MyPostMethod {
    @Autowired
    public User user;

    @PostMapping(value = "/login")
    @ApiOperation(value = "实现登陆接口", httpMethod = "POST")
    public R login(
            HttpServletResponse response,
            @RequestParam(name = "userName", required = true) String userName,
            @RequestParam(name = "password", required = true) String password) {
        if (userName.equals("zhangsan") && password.equals("123456")) {
            Cookie cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return new R<>().data(userName);
        }
        return new R<>().data("用户名或密码错误");
    }

    @PostMapping(value = "/getUser")
    @ApiOperation(value = "post方法得到user")
    public R getUser(HttpServletRequest request,
                          @RequestBody User u) {
        //获取cookies
        Cookie[] cookies = request.getCookies();
        //验证cookies
        for (Cookie cookie :
                cookies) {
            if (cookie.getName().equals("login")
                    && cookie.getValue().equals("true")
                    && u.getUserName().equals("zhangsan")
                    && u.getPassword().equals("123456"))
            {
                user.setUserName("lisi");
                user.setStatus(0);

                return new R<>().data(user);
            }
        }
        return new R<>().data("cookies验证失败");
    }

}
