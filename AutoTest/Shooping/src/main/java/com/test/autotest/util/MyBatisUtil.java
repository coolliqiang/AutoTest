package com.test.autotest.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    public final static String MapperConfigXMLFileName_default = "mybatis-config.xml";
    public final static String MapperConfigXMLFileName_add = "mybatis-config1.xml";
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSession getSqlSession(String configFileName){
        try {
            //加载核心配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream(configFileName);
            //获取sqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //获取sqlSessionFactory工厂对象
            sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory.openSession(true);
    }


}
