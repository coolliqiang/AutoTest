package com.test.autotest;

import com.test.autotest.bean.User;
import com.test.autotest.mapper.UserMapper;
import com.test.autotest.mapper.UserMapper1;
import com.test.autotest.util.DataUtils;
import com.test.autotest.util.MyBatisUtil;
import lombok.Data;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;

import static com.test.autotest.util.MyBatisUtil.MapperConfigXMLFileName_add;
import static com.test.autotest.util.MyBatisUtil.MapperConfigXMLFileName_default;

public class MyBatisTest {
    @Test(enabled = false)
    public void testInsertUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_default);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("");
        user.setPassword("");
        user.setCheckId(16);
        user.setCaseDesc("");
        int result = mapper.insert(user);
        System.out.println("result:"+result);


        List<User> users = mapper.selectAll();
        System.out.println(users);
    }


    @Test(enabled = false)
    public void testSelectOne(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_default);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectOneByCaseName("密码长度超限");

        System.out.println(user);
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

}
