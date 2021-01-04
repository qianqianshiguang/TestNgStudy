package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: gq
 * @createtime: 2020/12/7 10:29
 * @description: 启动类
 */
@SpringBootApplication//springboot的全局的自动配置注解
@MapperScan("com.example.demo.mapper")//mapper包下的接口类，在编译之后都会生成相应的实体类
public class Application {

    public static void main(String[] args) {
        // 固定的代码 启动springboot程序 初始化spring容器
        SpringApplication.run(Application.class, args);
    }

}
