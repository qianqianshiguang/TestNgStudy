package com.course.testcases;

import com.alibaba.fastjson.JSONObject;
import com.course.config.TestConfig;
import com.course.entity.UpdateUserCase;
import com.course.utils.DatabaseUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author: gq
 * @createtime: 2020/12/28 17:42
 * @description: 更新用户信息
 */
public class UpdateUser {
    @Test(dependsOnGroups = {"loginTrue"})
    public void updateUser() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        UpdateUserCase updateUserCase = sqlSession.selectOne("updateUserCase", 1);

        String result = getResult(updateUserCase);
        //断言
        Assert.assertEquals(updateUserCase.getExpected(), result);

    }

    public String getResult(UpdateUserCase updateUserCase) throws IOException {
//        HttpPost httpPost = new HttpPost(TestConfig.updateUserUrl);
        HttpPut httpPut = new HttpPut(TestConfig.updateUserUrl);
        //请求头
        httpPut.setHeader("content-type", "application/json");

        //请求参数
        JSONObject params = new JSONObject();
        params.put("userId", updateUserCase.getUserId());
        params.put("userName", updateUserCase.getUserName());
        params.put("password", updateUserCase.getPassword());
        params.put("status", updateUserCase.getStatus());
        StringEntity entity = new StringEntity(params.toString(), "utf-8");
        httpPut.setEntity(entity);

        CloseableHttpResponse response = TestConfig.httpClient.execute(httpPut);
        String result = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = JSONObject.parseObject(result);
        String data = jsonObject.getString("data");

        return data;
    }
}
