package com.course.testng;

import org.testng.annotations.*;

/**
 * @author: gq
 * @createtime: 2020/11/26 14:54
 * @description: TODO
 */
public class BasicAnntation {
    //基本的testng标注，用来把方法标注为测试的一部分
    @Test
    public void test1() {
        System.out.println("Thread id: " + Thread.currentThread().getId());
        System.out.println("test1这是一个测试脚本");
    }

    @Test
    public void test2() {
        System.out.println("test2这是一个测试脚本");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod这是在测试方法之前运行的");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod这是在测试方法之后运行的");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass这是在类运行之前运行的");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass这是在类运行之后运行的");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite测试套件，类之前运行");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite测试套件，类之后运行");
    }

//    @BeforeTest
//    public void beforeTest() {
//        System.out.println();
//    }
//
//    @AfterTest
//    public void afterTest() {
//        System.out.println();
//    }
}
