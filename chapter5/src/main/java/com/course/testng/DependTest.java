package com.course.testng;

import org.testng.annotations.Test;

/**
 * @author: gq
 * @createtime: 2020/11/27 15:52
 * @description: 依赖测试
 */
public class DependTest {
    @Test
    public void test1() {
        System.out.println("test1测试");
        throw new RuntimeException();

    }

    @Test(dependsOnMethods = "test1")
    public void test2() {
        System.out.println("test2测试");
    }
}
