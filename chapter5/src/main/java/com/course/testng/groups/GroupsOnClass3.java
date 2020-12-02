package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author: gq
 * @createtime: 2020/11/27 09:53
 * @description: TODO
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1() {
        System.out.println("teacher1====");
    }

    public void teacher2() {
        System.out.println("tescher2====");
    }
}
