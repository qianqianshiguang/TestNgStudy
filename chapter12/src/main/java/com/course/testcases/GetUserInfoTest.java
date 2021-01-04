package com.course.testcases;

import com.alibaba.fastjson.JSONObject;
import com.course.config.TestConfig;
import com.course.entity.GetUserInfoCase;
import com.course.utils.DatabaseUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author: gq
 * @createtime: 2020/12/24 10:55
 * @description: 获取user信息
 */
public class GetUserInfoTest {

    @Test(dependsOnGroups = {"loginTrue"},description = "获取用户信息")
    public void getUserInfo() throws IOException {
        //从数据库读取测试数据
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase = sqlSession.selectOne("getUserInfoCase", "1");
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);

        //发送请求
        String result = getResult(getUserInfoCase);
        //断言数据
        Assert.assertEquals(getUserInfoCase.getExpected(), result);

    }

    public String getResult(GetUserInfoCase getUserInfoCase) throws IOException {
        HttpPost httpPost = new HttpPost(TestConfig.getUserInfoUrl);

        //请求头
        httpPost.setHeader("content-type", "application/json");

        //传递的参数
        JSONObject params = new JSONObject();
        params.put("userName", getUserInfoCase.getUserName());
        params.put("password", getUserInfoCase.getPassword());
        StringEntity entity = new StringEntity(params.toString(), "utf-8");
        httpPost.setEntity(entity);

        CloseableHttpResponse response = TestConfig.httpClient.execute(httpPost);
        String result = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONObject data = jsonObject.getJSONObject("data");
        String userName = data.getString("userName");
        System.out.println(userName);

        return userName;

    }


}

