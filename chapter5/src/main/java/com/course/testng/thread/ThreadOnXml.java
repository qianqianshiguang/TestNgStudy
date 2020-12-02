package com.course.testng.thread;

import org.testng.annotations.Test;

/**
 * @author: gq
 * @createtime: 2020/12/1 10:40
 * @description: TODO
 */
public class ThreadOnXml {
    @Test
    public void test1() {
        System.out.println("Thread id: " + Thread.currentThread().getId());
    }

    @Test
    public void test2() {
        System.out.println("Thread id: " + Thread.currentThread().getId());
    }

    @Test
    public void test3() {
        System.out.println("Thread id: " + Thread.currentThread().getId());
    }

    @Test
    public void test4() {
        System.out.println("Thread id: " + Thread.currentThread().getId());
    }
}
