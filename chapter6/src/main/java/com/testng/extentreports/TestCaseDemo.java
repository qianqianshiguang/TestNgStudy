package com.testng.extentreports;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @author: gq
 * @createtime: 2020/12/2 11:59
 * @description: TODO
 */
public class TestCaseDemo {
    @Test
    public void test1() {
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2() {
        Assert.assertEquals(1,1);
    }

    @Test
    public void test3() {
        Assert.assertEquals("aaa","aaa");
    }

    @Test
    public void logDemo() {
        Reporter.log("这是我自己抛出的日程");
        throw new RuntimeException();
    }
}

