package com.course.testcases;

import com.alibaba.fastjson.JSONObject;
import com.course.config.TestConfig;
import com.course.entity.AddUserCase;
import com.course.entity.User;
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
 * @createtime: 2020/12/28 15:43
 * @description: 添加用户
 */
public class AddUserTest {
    @Test(dependsOnGroups = {"loginTrue"})
    public void addUser() throws IOException, InterruptedException {
        //获取测试数据
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        AddUserCase addUserCase = sqlSession.selectOne("addUserCase", 1);

        String result = getResult(addUserCase);
        Thread.sleep(10000);

        User user = sqlSession.selectOne("addUser", addUserCase);
        System.out.println(user.toString());
        //断言
        Assert.assertEquals(addUserCase.getExpected(), result);

    }

    public String getResult(AddUserCase addUserCase) throws IOException {
        HttpPost httpPost = new HttpPost(TestConfig.addUserUrl);

        //请求头
        httpPost.setHeader("content-type", "application/json");

        //传递的参数
        JSONObject params = new JSONObject();
        params.put("userName", addUserCase.getUserName());
        params.put("password", addUserCase.getPassword());
        params.put("email", addUserCase.getEmail());
        StringEntity entity = new StringEntity(params.toString(), "utf-8");
        httpPost.setEntity(entity);

        CloseableHttpResponse response = TestConfig.httpClient.execute(httpPost);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String data = jsonObject.getString("data");
        return data;
    }
}
