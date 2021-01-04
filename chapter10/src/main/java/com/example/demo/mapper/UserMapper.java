package com.example.demo.mapper;

import com.example.demo.entity.User;

import java.util.List;

/**
 * @author: gq
 * @createtime: 2020/12/11 17:01
 * @description: 数据层
 */
public interface UserMapper {
    /**
     * 查询所有用户
     * @return
     */
    List<User> queryAll();

    /**
     * 根据条件查询用户
     * @param userName
     * @return
     */
    User queryOne(String userName);

    /**
     * 增加用户
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    Boolean updateUser(User user);

    /**
     * 删除用户
     * @param userName
     * @return
     */
    Boolean deleteUser(String userName);


}
