package com.course.httpclient.demo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author: gq
 * @createtime: 2020/12/4 10:44
 * @description: httpclient demo test
 */
public class MyHttpclient {
    @Test
    public void test1() throws IOException {
        HttpGet get = new HttpGet("http://www.baidu.com");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
    }
}
