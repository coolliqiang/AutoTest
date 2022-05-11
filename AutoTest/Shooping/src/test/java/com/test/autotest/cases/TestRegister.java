package com.test.autotest.cases;

import com.test.autotest.bean.User;
import com.test.autotest.mapper.UserMapper;
import com.test.autotest.mapper.UserMapper1;
import com.test.autotest.util.DataUtils;
import com.test.autotest.util.MyBatisUtil;
import com.test.autotest.util.MyHttpUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static com.test.autotest.util.MyBatisUtil.MapperConfigXMLFileName_add;
import static com.test.autotest.util.MyBatisUtil.MapperConfigXMLFileName_default;

public class TestRegister {
    private static Logger logger = LoggerFactory.getLogger(TestRegister.class);
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
        users = DataUtils.getAllCases();
        return users;
    }

    /*@DataProvider
    public static Object[][] toData(){
        return DataUtils.datas();
    }*/

  /*  @Test(dataProvider = "toData")
    public void testRegister(String username,String password){
        String result = MyHttpUtils.doPost(username, password);
        System.out.println(result);
        if(result.contains("100")){
            Assert.assertTrue(result.contains("false"),"passed");
        }else {
            Assert.assertTrue(result.contains("true"),"passed");
        }
    }*/

/*    @Test(groups = "注册接口",description = "执行所有用例")
    public void testRegister0(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_default);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        String result = null;
        for(User user:users){
            String username = user.getUsername();
            String password = user.getPassword();
            result = MyHttpUtils.doPost(username, password);
            //打印用例日志

            logger.info("用例id:"+user.getId()+",用户名:"+user.getUsername()+",密码:"
                    +user.getPassword()+",用例描述："+user.getCaseDesc());
            System.out.println();
            logger.info("测试结果："+result);
        }
        if(result!=null){
            if(result.contains("100")){
                Assert.assertTrue(result.contains("false"),"passed");
            }else {
                Assert.assertTrue(result.contains("true"),"passed");
            }
        }

    }*/
    @Test(groups = "注册接口",description = "正确的用户名和密码")
    public void testRegister1(){
        boolean expected = true;
        String caseName = "正确的用户名和密码";
        for (User user:users){
            if(DataUtils.isCaseNameExists(user)){
                //判断如何用例满足条件则取出接口所需字段并调用接口
                if(caseName.equals(user.getCaseDesc())){
                    String result = MyHttpUtils.doPost(user.getUsername(), user.getPassword());
                    logger.info("用例id:"+user.getId()+",用户名:"+user.getUsername()+",密码:"
                            +user.getPassword()+",用例描述："+user.getCaseDesc());
                    //断言
                    expected = result.contains("200");
                    Assert.assertTrue(expected);
                    logger.info("测试结果："+result);
                    System.out.println();

                }
            }
        }
    }

    @Test(groups = "注册接口",description = "用户名为空")
    public void testRegister2(){
        String caseName = "用户名为空";
        boolean expected = true;
        UserMapper mapper = getUserMapper();
        User user = mapper.selectOneByCaseName(caseName);
        if(DataUtils.isCaseNameExists(user)){
            String result = MyHttpUtils.doPost(user.getUsername(), user.getPassword());
            logger.info("用例id:"+user.getId()+",用户名:"+user.getUsername()+",密码:"
                    +user.getPassword()+",用例描述："+user.getCaseDesc());
            //断言
            expected = result.contains("100");
            Assert.assertTrue(expected);
            logger.info("测试结果："+result);
            System.out.println();
        }

    }

    private UserMapper getUserMapper() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_default);
        return sqlSession.getMapper(UserMapper.class);
    }

    @Test(groups = "注册接口",description = "密码为空")
    public void testRegister3(){
        String caseName = "密码为空";
        boolean expected = true;
        UserMapper mapper = getUserMapper();
        User user = mapper.selectOneByCaseName(caseName);
        if(DataUtils.isCaseNameExists(user)){
            String result = MyHttpUtils.doPost(user.getUsername(), user.getPassword());
            logger.info("用例id:"+user.getId()+",用户名:"+user.getUsername()+",密码:"
                    +user.getPassword()+",用例描述："+user.getCaseDesc());
            expected = result.contains("100");
            Assert.assertTrue(expected);
            logger.info("测试结果："+result);
            System.out.println();
        }


    }

    @Test(groups = "注册接口",description = "用户名已存在")
    public void testRegister4(){
        String caseName = "用户名已存在";
        UserMapper mapper = getUserMapper();
        User user = mapper.selectOneByCaseName(caseName);
        if(DataUtils.isCaseNameExists(user)){
            boolean expected = true;
            String result = MyHttpUtils.doPost(user.getUsername(), user.getPassword());
            logger.info("用例id:"+user.getId()+",用户名:"+user.getUsername()+",密码:"
                    +user.getPassword()+",用例描述："+user.getCaseDesc());
            //断言
            expected = result.contains("100");
            Assert.assertTrue(expected);
            logger.info("测试结果："+result);
            System.out.println();
        }

    }

    @Test(groups = "注册接口",description = "用户名带有空格字符")
    public void testRegister5(){
        String caseName = "用户名带有空格字符";
        UserMapper mapper = getUserMapper();
        User user = mapper.selectOneByCaseName(caseName);
        if(DataUtils.isCaseNameExists(user)){
            String result = MyHttpUtils.doPost(user.getUsername(), user.getPassword());
            logger.info("用例id:"+user.getId()+",用户名:"+user.getUsername()+",密码:"
                    +user.getPassword()+",用例描述："+user.getCaseDesc());

            boolean expected = true;
            //断言
            expected = result.contains("100");
            Assert.assertTrue(expected);
            logger.info("测试结果："+result);
            System.out.println();
        }

    }

    @Test(groups = "注册接口",description = "用户名长度超限")
    public void testRegister6(){
        String caseName = "用户名长度超限";
        String result = null;
        UserMapper userMapper = getUserMapper();
        User user = userMapper.selectOneByCaseName(caseName);
        if(DataUtils.isCaseNameExists(user)){
            result = MyHttpUtils.doPost(user.getUsername(), user.getPassword());
            logger.info("用例id:"+user.getId()+",用户名:"+user.getUsername()+",密码:"
                    +user.getPassword()+",用例描述："+user.getCaseDesc());
            //断言
            boolean expected = true;
            expected = result.contains("100");
            Assert.assertTrue(expected);
            logger.info("测试结果："+result);
            System.out.println();
        }

    }

    @Test(groups = "注册接口",description = "用户名长度少于规则长度")
    public void testRegister7(){
        String casesName = "用户名长度少于规则长度";
        boolean expected = true;
        String result = null;
        for (User user:users){
            if(DataUtils.isCaseNameExists(user)){
                //判断如何用例满足条件则取出接口所需字段并调用接口
                if(casesName.equals(user.getCaseDesc())){
                    result = MyHttpUtils.doPost(user.getUsername(), user.getPassword());
                    logger.info("用例id:"+user.getId()+",用户名:"+user.getUsername()+",密码:"
                            +user.getPassword()+",用例描述："+user.getCaseDesc());
                    //断言
                    expected = result.contains("100");
                    Assert.assertTrue(expected);
                    logger.info("测试结果："+result);
                    System.out.println();
                }
            }
        }
    }


}
