package com.test.autotest;

import com.test.autotest.bean.RegisterInfo;
import com.test.autotest.mapper.RegisterInfoMapper;
import com.test.autotest.mapper.UserMapper1;
import com.test.autotest.util.MyBatisUtil;
import com.test.autotest.util.MyHttpUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;

import static com.test.autotest.util.MyBatisUtil.MapperConfigXMLFileName_add;
import static com.test.autotest.util.MyBatisUtil.MapperConfigXMLFileName_default;

public class MyBatisTest {
    @Test(enabled = false)
    public void testInsertUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_default);
        RegisterInfoMapper mapper = sqlSession.getMapper(RegisterInfoMapper.class);
        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setUsername("");
        registerInfo.setPassword("");
        registerInfo.setCheckId(16);
        registerInfo.setCaseDesc("");
        int result = mapper.insert(registerInfo);
        System.out.println("result:"+result);


        List<RegisterInfo> registerInfos = mapper.selectAll();
        System.out.println(registerInfos);
    }


    @Test(enabled = false)
    public void testSelectOne(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_default);
        RegisterInfoMapper mapper = sqlSession.getMapper(RegisterInfoMapper.class);
        RegisterInfo registerInfo = mapper.selectOneByCaseName("密码长度超限");

        System.out.println(registerInfo);
    }
  //删除接口库的数据
    @Test(enabled = false)
    public void testDeleteAll(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_add);
        UserMapper1 mapper = sqlSession.getMapper(UserMapper1.class);
        mapper.deleteAll();
    }


    @Test(enabled = false)
    public void test(){
        System.out.println("***********************执行了MybatisTest类************************");
    }


    @Test(enabled = false)
    public void testUrlConfigFile(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_default);
        RegisterInfoMapper mapper = sqlSession.getMapper(RegisterInfoMapper.class);
        RegisterInfo registerInfo = mapper.selectOneByCaseName("密码长度超限");

        String result = MyHttpUtils.doPost(registerInfo.getUsername(), registerInfo.getPassword());
        System.out.println("测试结果为："+result);

    }

}
