package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * @author: gq
 * @createtime: 2020/12/18 15:20
 * @description: 定义接口的url
 */
public class TestConfig {

    public static String loginUrl;
    public static String updateUserUrl;
    public static String getUserListUrl;
    public static String getUserInfoUrl;
    public static String addUserUrl;

    public static CloseableHttpClient httpClient;
    public static CookieStore cookieStore;

}


