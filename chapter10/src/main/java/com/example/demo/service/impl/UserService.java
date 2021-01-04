package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: gq
 * @createtime: 2020/12/11 17:01
 * @description: IuserService实现类程序
 */
@Service
public class UserService implements IUserService {
    @Resource
    UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     */
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    /**
     * 根据条件查询用户
     * @param userName
     * @return
     */
    public User queryOne(String userName) {
        return userMapper.queryOne(userName);
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    public Boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    //删除用户
    public Boolean deleteUser(String userName) {
        return userMapper.deleteUser(userName);
    }
}
