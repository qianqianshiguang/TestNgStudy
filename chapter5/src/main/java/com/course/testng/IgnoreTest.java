package com.course.testng;

import org.testng.annotations.Test;

/**
 * @author: gq
 * @createtime: 2020/11/26 18:03
 * @description: 忽略测试
 */
public class IgnoreTest {
    @Test(enabled = false)
    public void ignore1() {
        System.out.println("忽略1");
    }

    @Test(enabled = true)
    public void ignore2() {
        System.out.println("忽略2");
    }

    @Test
    public void ignore3() {
        System.out.println("忽略3");
    }
}
