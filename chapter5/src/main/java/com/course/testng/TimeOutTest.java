package com.course.testng;

import org.testng.annotations.Test;

/**
 * @author: gq
 * @createtime: 2020/12/1 11:09
 * @description: TODO
 */
public class TimeOutTest {
    @Test(timeOut = 3000)//毫秒级别
    public void timeoutSuccess() {
        try {
            Thread.sleep(2000);
            System.out.println("不超时");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(timeOut = 2000)
    public void timeoutFailed() {
        try {
            Thread.sleep(3000);
            System.out.println("不超时");

        } catch (InterruptedException e) {
            System.out.println("超时失败");
            e.printStackTrace();
        }

    }
}
