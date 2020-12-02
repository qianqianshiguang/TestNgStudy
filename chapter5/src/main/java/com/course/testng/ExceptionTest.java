package com.course.testng;

import org.testng.annotations.Test;

/**
 * @author: gq
 * @createtime: 2020/11/27 15:33
 * @description: 异常测试
 */
public class ExceptionTest {
    @Test(expectedExceptions = RuntimeException.class)
    public void exceptionTest1() {
        System.out.println("这是一个异常测试");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void exceptionTest2() {
        System.out.println("这是一个异常测试");
        throw new RuntimeException();
    }
}
