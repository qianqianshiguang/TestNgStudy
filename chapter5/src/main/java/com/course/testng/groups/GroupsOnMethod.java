package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @author: gq
 * @createtime: 2020/11/26 19:17
 * @description: TODO
 */
public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1() {
        System.out.println("服务端测试1");
    }

    @Test(groups = "server")
    public void test2() {
        System.out.println("服务端测试2");
    }
    @Test(groups = "client")
    public void test3() {
        System.out.println("客户端测试1");
    }
    @Test(groups = "client")
    public void test4() {
        System.out.println("客户端测试2");
    }
    @BeforeGroups("server")
    public void beforeGroups() {
        System.out.println("服务端运行之前运行的组");
    }

    @AfterGroups("server")
    public void afterGroups() {
        System.out.println("服务端运行之后运行的组");
    }

    @BeforeGroups("client")
    public void beforeGroupsClient() {
        System.out.println("客户端运行之前运行的组");
    }

    @AfterGroups("client")
    public void afterGroupsClient() {
        System.out.println("客户端运行之后运行的组");
    }
}

