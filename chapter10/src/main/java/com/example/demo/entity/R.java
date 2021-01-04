package com.example.demo.entity;

import lombok.Data;

/**
 * @author: gq
 * @createtime: 2020/12/11 20:22
 * @description: json封装的实体类，对返回数据格式进行处理
 */
@Data
public class R<T> {
    int code = 0;
    String msg = "success";
    T data;

    public R() {
    }

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R data(T t){
        this.data = t;
        return this;
    }
}
