package com.course.testng;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author: gq
 * @createtime: 2020/11/27 16:57
 * @description: 参数化练习
 */
public class DataProvider {
    @Test(dataProvider = "provider")
    public void test1(String name, String age) {
        System.out.println("name:" + name + ",age:" + age);
    }

    @Test(dataProvider = "provider")
    public void test2(String name, String age) {
        System.out.println("name:" + name + ",age:" + age);
    }

    @org.testng.annotations.DataProvider(name = "provider")
    public Object[][] dataProvider(Method method) {

        Object[][] o = new Object[][]{
                {"zhangsan", "10"},
                {"lisi", "20"}
        };
        return o;
    }

    @Test(dataProvider = "methodTest")
    public void test3(String name, int age, String sex) {
        System.out.println("name:" + name + ",age:" + age + ",sex:" + sex);
    }

    @Test(dataProvider = "methodTest")
    public void test4(String name, int age) {
        System.out.println("name:" + name + ",age:" + age);
    }

    @org.testng.annotations.DataProvider(name = "methodTest")
    public Object[][] methodDataProviderTest(Method method) {
        Object[][] result = null;
        if (method.getName().equals("test3")) {
            result = new Object[][]{
                    {"zhansan", 50, "woman"},
                    {"lisi", 60, "man"}
            };


        } else if (method.getName().equals("test4")) {
            result = new Object[][]{
                    {"wangwu", 40},
                    {"zhongyi", 35},
                    {"daxiong", 12}
            };
        }
        return result;
    }
//    @org.testng.annotations.DataProvider(name = "methodTest")
//    public Object[][] methodDataProviderTest1(Method method) {
//        Object[] result = new Object[2];
//        if (method.getName().equals("test3")) {
//
//            result[0]=new User("zhansan", 50);
//            result[1]=new User("lisi", 60);
//
//        }
//
//        return result;
//
//
//    }
//    public static class User {
//        private String username;
//        private int age;
//
//        public User(String username, int age) {
//            this.username = username;
//            this.age = age;
//        }
//    }


}
