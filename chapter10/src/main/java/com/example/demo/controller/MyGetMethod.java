package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: gq
 * @createtime: 2020/12/7 16:25
 * @description: get方法集合
 */
@Api(value = "测试接口", tags = {"Get方法实现"})
@RestController
public class MyGetMethod {
    @RequestMapping(value = "/getcookies", method = RequestMethod.GET)
    @ApiOperation(value = "获取cookies信息",httpMethod = "GET")
    public String getCookies(HttpServletResponse response) {
        //HttpServletResponse 装响应信息的类
        //HttpServletRequest 装请求信息的类
        Cookie cookie = new Cookie("cookie", "123456");
        response.addCookie(cookie);
        return "cookies信息返回成功";
    }

    /**
     * 客户端必须携带cookies信息
     * 这是一个带着cookies信息的get方法
     */
    @RequestMapping(value = "/getwithcookies", method = RequestMethod.GET)
    @ApiOperation(value = "客户端必须携带cookies信息", httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你必须携带cookies信息";
        }
        for (Cookie cookie :
                cookies) {
            if (cookie.getName().equals("cookie") && cookie.getValue().equals("123456")) {
                return "这是一个带着cookies信息的get方法";
            }
        }

        return "你必须携带cookies信息";
    }

    /**
     * 携带参数的get方法
     * 第一种实现方式
     * 获取商品列表
     * url:host:port/path?start=""&end=""
     */
    @RequestMapping(value = "/getWithParam", method = RequestMethod.GET)
    @ApiOperation(value = "必须携带参数的get方法实现方式1", httpMethod = "GET")
    public Map getWithParam(@RequestParam(value = "start", defaultValue = "10") Integer start,
                            @RequestParam(value = "end", defaultValue = "20") Integer end) {
        Map<String, Object> map = new HashMap();
        map.put("衬衣", 100);
        map.put("方便面", "一袋");
        map.put("可乐", 5);

        return map;
    }

    /**
     * 携带参数的get方法
     * 第二种实现方式
     * 获取商品列表
     * url:host:port/path/{start}/{end}
     */
    @RequestMapping(value = "/getWithParam1/{start}/{end}", method = RequestMethod.GET)
    @ApiOperation(value = "必须携带参数的get方法实现方式2", httpMethod = "GET")
    public Map getWithParam1(@PathVariable(value = "start") Integer start,
                             @PathVariable(value = "end") Integer end) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("衬衣", 100);
        map.put("方便面", 1);
        map.put("可乐", 5);
        return map;
    }
}

