package com.test.autotest.util;

import com.test.autotest.bean.User;
import com.test.autotest.mapper.UserMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class MyHttpUtils {
    public static String doPost(String username,String password){
        String result = null;
        try {
            String url = "http://192.168.1.101:8080/user/register";
            //1.创建post对象，以post方式提交接口请求
            HttpPost httpPost = new HttpPost(url);
            //2.提交参数
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        BasicNameValuePair basicNameValuePair1 = new BasicNameValuePair("username", "小米");
//        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("password", "123456");
//        params.add(basicNameValuePair1);
//        params.add(basicNameValuePair2);
//        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params, "utf-8");
//        urlEncodedFormEntity.setContentType("application/json");
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("username",username);
            jsonParam.put("password",password);
            StringEntity stringEntity = new StringEntity(jsonParam.toString(), "utf-8");
            //设置
            stringEntity.setContentType("application/json");
            //3.将参数封装到请求体中
            httpPost.setEntity(stringEntity);
            //4.装备客户端对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //5.提交请求-->执行请求
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            //6.获取响应体
            HttpEntity entity = httpResponse.getEntity();
            //7.解析接口返回数据，输出日志
            result = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
