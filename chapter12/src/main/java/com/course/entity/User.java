package com.course.entity;

import lombok.Data;

/**
 * @author: gq
 * @createtime: 2020/12/18 12:29
 * @description: 实体类user
 */
@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private String userId;
    private String email;
    private String status;

    @Override
    public String toString() {
        return (
                "{id:"+id+","+
                "userName:"+userName+","+
                "password:"+password+","+
                "sex:"+ userId +","+
                "permission:"+ email +","+
                "isDelete:"+ status +"}"
        );
    }

}
