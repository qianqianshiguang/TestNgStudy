package com.example.demo.controller;

import com.example.demo.entity.R;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: gq
 * @createtime: 2020/12/9 11:06
 * @description: 用户层
 */
@RestController
@Slf4j
@RequestMapping(value = "/user")
@Api(value = "userController",tags = {"用户层"})
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 查询所有用户
     */
    @GetMapping(value = "/queryAll")
    public R<List<User>> queryAll() {
        //R<List<User>> r = new R();
        //r.setData(userService.queryAll());
        //return r;
        List<User> users = userService.queryAll();
        log.info("****查找结果" + users);
        if (users != null) {
            return new R<>().data(users);
        }
        return new R<>().data("未查询到用户");
    }

    /**
     * 根据条件查询用户
     * @param userName
     * @return
     */
    @GetMapping(value = "/queryOne/{userName}")
    public R<User> queryOne(@PathVariable(value = "userName") String userName) {
        User user = userService.queryOne(userName);
        log.info("****查找结果" + user);
        if (user != null) {
            return new R<>().data(user);
        }
        return new R<>().data("未查询到此用户");
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @PostMapping(value = "/addUser")
    public R addUser(@RequestBody User user) {
        Integer result = userService.addUser(user);
        log.info("****添加用户" + user);
        if (result > 0) {
            return new R().data(result);
        }
        return new R().data("添加失败");

    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PutMapping(value = "/updateUser")
    public R updateUser(@RequestBody User user) {
        Boolean flag = userService.updateUser(user);
        log.info("****修改用户" + user);
        if (flag) {
            return new R().data("修改成功");
        }
        return new R().data("修改失败");
    }

    /**
     * 删除用户
     * @param userName
     * @return
     */
    @DeleteMapping(value = "/deleteUser")
    public R deleteUser(@RequestParam(value = "userName") String userName) {
        Boolean flag = userService.deleteUser(userName);
        log.info("****删除用户" + userName);
        if (flag) {
            return new R().data("删除成功");
        }
        return new R().data("删除失败");
    }

}
