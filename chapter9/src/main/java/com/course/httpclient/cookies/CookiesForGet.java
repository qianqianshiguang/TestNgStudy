package com.course.httpclient.cookies;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author: gq
 * @createtime: 2020/12/4 12:20
 * @description: get方法获取cookies
 */
public class CookiesForGet {
    private String url;
    private ResourceBundle bundle;
    //存储cookie信息的变量
    private CookieStore cookieStore;

    /**
     * 获取配置文件
     */
    @BeforeTest
    public void BeforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    /**
     * 获取cookie
     * @throws IOException
     */
    @Test
    public void testGetCookies() throws IOException {
        String uri = bundle.getString("test.uri");
        String host = this.url + uri;
        //获取cookies信息
        this.cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
//        CloseableHttpClient httpClient = HttpClients.createDefault();

        //逻辑代码实现
        HttpGet get = new HttpGet(host);
        CloseableHttpResponse response = httpClient.execute(get);

        //打印返回值
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        //读取cookie信息
        List<Cookie> cookieList = cookieStore.getCookies();
        for (Cookie cookie :
                cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name:" + name + ";  cookie value:" + value);
        }
    }

    /**
     * 1.带cookie
     * 2.get方法
     * @throws IOException
     */
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {

        String uri = bundle.getString("test.getwithcookies");
        String host = this.url + uri;

        //设置cookies信息
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();

        //逻辑代码实现
        HttpGet get = new HttpGet(host);
        CloseableHttpResponse response = httpClient.execute(get);

        //打印返回值
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if (statusCode == 200) {
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }else {
            System.out.println("状态码返回错误，执行失败");
        }

    }

    /**
     * 1.带cookies
     * 2.post方法
     * 3.传参格式为forms
     * @throws IOException
     */
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostForCookiesForms() throws IOException {
        String uri = bundle.getString("test.postwithcookies");
        String host = this.url + uri;

        //设置cookie信息
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();

        //声明一个post方法
        HttpPost httpPost = new HttpPost(host);
        //设置请求头
        httpPost.setHeader("content-type", " application/x-www-form-urlencoded");

        //设置参数
//        HashMap hashMap = new HashMap();
//        hashMap.put("name", "huhansan");
//        hashMap.put("age", "18");
        String param = "name=huhansan&age=18";
        HttpEntity httpEntity = new StringEntity(param, "utf-8");
        httpPost.setEntity(httpEntity);

        //获取返回值
        CloseableHttpResponse response = httpClient.execute(httpPost);

        //打印返回值
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if (statusCode == 200) {
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }
        else {
            System.out.println("执行失败");
        }

    }

    /**
     * 1.带cookies
     * 2.post方法
     * 3.传参格式为json
     * @throws IOException
     */
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostForCookiesJson() throws IOException {
        String uri = bundle.getString("test.postwithcookiesjson");
        String host = this.url + uri;

        //声明client，设置cookie信息
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();

        //声明一个post方法
        HttpPost httpPost = new HttpPost(host);
        //设置请求头
        httpPost.setHeader("content-type", " application/json");

        //添加参数(可通过hashmap和jsonobject实现)
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name", "huhansan");
//        jsonObject.put("age", 18);
//        HttpEntity httpEntity = new StringEntity(String.valueOf(jsonObject), "utf-8");
//        httpPost.setEntity(httpEntity);

        //添加参数
        HashMap hashMap = new HashMap();
        hashMap.put("name", "huhansan");
        hashMap.put("age", 18);

        //将参数添加到post中
        StringEntity entity = new StringEntity(JSON.toJSONString(hashMap), "utf-8");
        httpPost.setEntity(entity);


        //获取返回值
        CloseableHttpResponse response = httpClient.execute(httpPost);

        //打印返回值
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            //获得结果
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            //获取实际结果
            JSONObject jsonResult = JSONObject.parseObject(result);
            int code = (Integer) jsonResult.get("code");
            String res = (String) jsonResult.get("res");
            //判断预期结果是否一致
            Assert.assertEquals(code, 0);
            Assert.assertEquals(res, "success");
            System.out.println("执行成功");

        }
        else {
            System.out.println("执行失败");
        }


    }
}

