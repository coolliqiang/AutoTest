package com.test.autotest;

import com.test.autotest.bean.User;
import com.test.autotest.mapper.UserMapper;
import com.test.autotest.mapper.UserMapper1;
import com.test.autotest.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import static com.test.autotest.util.MyBatisUtil.MapperConfigXMLFileName_add;
import static com.test.autotest.util.MyBatisUtil.MapperConfigXMLFileName_default;

public class MyBatisTest {
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_default);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.insert(new User("李子","123123"));
        System.out.println("result:"+result);


        /*List<User> users = mapper.selectAll();
        System.out.println(users);*/
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_default);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectOne(1);
        System.out.println(user);
    }
    //删除接口库的数据
    @Test
    public void testDeleteAll(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_add);
        UserMapper1 mapper = sqlSession.getMapper(UserMapper1.class);
        mapper.deleteAll();
    }

}
