package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author: gq
 * @createtime: 2020/12/7 11:55
 * @description: 测试get请求@GetMapping和@RequestMapping
 */
@RestController
@Slf4j
@Api(value = "测试接口",tags = {"简单实现hello world"})
public class TestController {
    @GetMapping("/hello")
    @ApiOperation(value = "@GetMapping实现hello")
    public String hello(@RequestParam(value = "name", defaultValue = "world1") String name) {
        log.info("打印test-----info");
        log.error("打印test-----error");
        log.warn("打印test-----warn");
        log.debug("打印test-----debug");
        return String.format("Hello %s!", name);
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    @ApiOperation(value = "@RequestMapping实现hello")
    public String hello1(@RequestParam(value = "name", defaultValue = "world") String name) {
        return String.format("Hello %s!", name);
    }
}
