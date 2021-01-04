package com.course.controller;

import com.course.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: gq
 * @createtime: 2020/12/15 16:40
 * @description: TODO
 */
//@Log4j
@RestController
@RequestMapping("v1")
@Api(value = "v1", tags = {"demo测试"})
public class Demo {
    //获取一个执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;

    @GetMapping(value = "/getUserCount")
    @ApiOperation(value = "这是可以获取到用户数的api", httpMethod = "GET")
    public int getUserCount() {
        return template.selectOne("getUserCount");
    }

    @PostMapping(value = "/addUser")
    @ApiOperation(value = "添加用户的api", httpMethod = "POST")
    public int addUser(@RequestBody User user) {
        int result = template.insert("addUser", user);
        return result;
    }

    @PostMapping(value = "deleteUser")
    @ApiOperation(value = "删除用户",httpMethod = "POST")
    public int deleteUser(@RequestParam String userName) {
        return template.delete("deleteUser", userName);
    }

    @PostMapping(value = "updateUser")
    @ApiOperation(value = "修改用户",httpMethod = "POST")
    public int updateUser(@RequestBody User user) {
        return template.delete("updateUser", user);
    }

}
