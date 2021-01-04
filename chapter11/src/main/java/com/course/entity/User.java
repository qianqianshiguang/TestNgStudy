package com.course.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author: gq
 * @createtime: 2020/12/8 15:17
 * @description: 数据库表格对应的实体类User
 */
@Data
//@Repository
@Component
public class User {

    public static final long serialVersionUID = 1L;
    private Integer id;
    private String userId;
    private String userName;
    private String password;
    private String email;
    private Integer status;
}
