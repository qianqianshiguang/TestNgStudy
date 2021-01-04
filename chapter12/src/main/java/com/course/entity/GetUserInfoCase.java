package com.course.entity;

import lombok.Data;

/**
 * @author: gq
 * @createtime: 2020/12/18 14:43
 * @description: 获取用户信息
 */
@Data
public class GetUserInfoCase {
    private int id;
    private int userId;
    private String userName;
    private String password;
    private String expected;
}
