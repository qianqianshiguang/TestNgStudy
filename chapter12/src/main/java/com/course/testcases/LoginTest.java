package com.course.testcases;

import com.alibaba.fastjson.JSONObject;
import com.course.config.TestConfig;
import com.course.entity.InterfaceName;
import com.course.entity.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import com.course.utils.Login;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author: gq
 * @createtime: 2020/12/18 17:44
 * @description: 登陆测试
 */
public class LoginTest {

    Login login = new Login();

    /**
     * 测试前的准备
     * 1.获取接口url
     * 2.httpclient初始化
     */
    @BeforeTest(groups = "loginTrue", description = "测试准备工作")
    public void beforeTest() throws IOException {

        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSER);
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.updateUserUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);

        TestConfig.cookieStore = login.getCookieStore();
        TestConfig.httpClient = HttpClients.custom().setDefaultCookieStore(TestConfig.cookieStore).build();

    }

    @Test(groups = "loginTrue", description = "用户登陆成功接口测试")
    public void loginTrue() throws IOException {
        //数据库读取测试数据
        SqlSession sqlSession = DatabaseUtil.getSqlSession();

        LoginCase loginCase = sqlSession.selectOne("loginCase", 1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        // 发送请求
        String result = getResult(loginCase);
        // 验证结果
        Assert.assertEquals(loginCase.getExpected(), result);

    }

    @Test(groups = "loginFalse", description = "用户登陆失败接口测试")
    public void loginFalse() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();

        LoginCase loginCase = sqlSession.selectOne("loginCase", 2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        // 发送请求
        String result = getResult(loginCase);
        // 验证结果
        Assert.assertEquals(loginCase.getExpected(), result);

    }

    public String getResult(LoginCase loginCase) throws IOException {

        HttpPost httpPost = new HttpPost(TestConfig.loginUrl);

        //form格式传参
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("userName", loginCase.getUserName()));
        params.add(new BasicNameValuePair("password", loginCase.getPassword()));
        httpPost.setEntity(new UrlEncodedFormEntity(params));

//        //请求结果
        String result;
        CloseableHttpResponse response = TestConfig.httpClient.execute(httpPost);

        result = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.parseObject(result);
        String data = jsonObject.getString("data");

        return data;
    }
}
