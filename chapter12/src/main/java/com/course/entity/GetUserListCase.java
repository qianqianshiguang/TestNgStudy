package com.course.entity;

import lombok.Data;

/**
 * @author: gq
 * @createtime: 2020/12/18 14:44
 * @description: 获取用户列表
 */
@Data
public class GetUserListCase {
    private String userName;
    private Integer age;
    private String sex;
    private String expected;
}
