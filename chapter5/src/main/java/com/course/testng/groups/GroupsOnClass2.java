package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author: gq
 * @createtime: 2020/11/27 09:53
 * @description: TODO
 */
@Test(groups = "stu")
public class GroupsOnClass2 {
    public void stu1() {
        System.out.println("stu3====");
    }

    public void stu2() {
        System.out.println("stu4====");
    }
}
