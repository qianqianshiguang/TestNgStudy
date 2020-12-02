package com.course.testng.suite;

import org.testng.annotations.*;

/**
 * @author: gq
 * @createtime: 2020/11/26 16:46
 * @description: TODO
 */
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite测试套件");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest");
    }
}

