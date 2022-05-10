package com.test.autotest.cases;

import com.test.autotest.bean.User;
import com.test.autotest.mapper.UserMapper1;
import com.test.autotest.util.DataUtils1;
import com.test.autotest.util.MyBatisUtil;
import com.test.autotest.util.MyHttpUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.test.autotest.util.MyBatisUtil.MapperConfigXMLFileName_add;

public class TestRegister1 {


    private static List<User> users = null;
    //测试前清空接口库表数据
    @BeforeTest
    public void clearTable(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_add);
        UserMapper1 mapper = sqlSession.getMapper(UserMapper1.class);
        mapper.deleteAll();
    }
    //方法执行前取出所有用例
    @BeforeTest
    public static List<User> getAllCasesBeforeTest(){
        users = DataUtils1.getAllCases();
        return users;
    }

    @Test(groups = "注册接口",description = "正确的用户名和密码")
    public void testRegister1(){
        boolean expected = true;
        String result = null;
        for (User user:users){
            //判断如何用例满足条件则取出接口所需字段并调用接口
            if(user.getId()==1){
                result = MyHttpUtils.doPost(user.getUsername(), user.getPassword());
                System.out.println("用例id:"+user.getId()+",用户名:"+user.getUsername()+",密码:"
                        +user.getPassword()+",用例描述："+user.getCaseDesc());
                //断言
                expected = result.contains("200");
                Assert.assertTrue(expected);
                System.out.println("测试结果："+result);
                System.out.println();

            }
        }
    }
}
