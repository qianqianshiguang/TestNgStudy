package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author: gq
 * @createtime: 2020/12/18 17:35
 * @description: 数据库信息获取
 */
public class DatabaseUtil {
    private static SqlSessionFactory factory = null;
    public static SqlSession getSqlSession() throws IOException {

        if (factory == null) {
            //获取配置的资源文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
            //sqlSession能够执行配置文件中的sql语句
        }
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }
}
