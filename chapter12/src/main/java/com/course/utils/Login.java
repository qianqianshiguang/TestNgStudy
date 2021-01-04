package com.course.utils;

import com.course.config.TestConfig;
import com.course.entity.LoginCase;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: gq
 * @createtime: 2020/12/25 16:12
 * @description: TODO
 */
public class Login {
    CookieStore cookieStore;

    public CloseableHttpResponse login() throws IOException {
        //数据库读取测试数据
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase", 1);

        HttpPost httpPost = new HttpPost(TestConfig.loginUrl);

        cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        //form格式传参
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("userName", loginCase.getUserName()));
        params.add(new BasicNameValuePair("password", loginCase.getPassword()));
        httpPost.setEntity(new UrlEncodedFormEntity(params));

        //请求结果
        String result;
        CloseableHttpResponse response = httpClient.execute(httpPost);

        return response;
    }
    public CookieStore getCookieStore() throws IOException {

        login();
        return cookieStore;
    }

}
