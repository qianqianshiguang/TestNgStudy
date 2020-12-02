package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author: gq
 * @createtime: 2020/11/27 09:43
 * @description: TODO
 */
@Test(groups = "stu")
public class GroupsOnClass1 {
    public void stu1() {
        System.out.println("stu1====");
    }

    public void stu2() {
        System.out.println("stu2====");
    }
}
