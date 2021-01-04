package com.course.entity;

import lombok.Data;

/**
 * @author: gq
 * @createtime: 2020/12/18 14:42
 * @description: 添加用户信息
 */
@Data
public class AddUserCase {
    private String userName;
    private String password;
    private String userId;
    private String email;
    private String status;
    private String expected;

}
