package com.course.entity;

import lombok.Data;

/**
 * @author: gq
 * @createtime: 2020/12/18 14:44
 * @description: 登陆
 */
@Data
public class LoginCase {
    private int id;
    private String userName;
    private String password;
    private String expected;


}
