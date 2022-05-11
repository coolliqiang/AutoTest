package com.test.autotest.util;

import com.test.autotest.bean.User;
import com.test.autotest.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.DataProvider;

import java.util.List;

import static com.test.autotest.util.MyBatisUtil.MapperConfigXMLFileName_default;

public class DataUtils {
    private static Object[][] chooseAllCase(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_default);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        Object[][] data = new Object[users.size()][];
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            /* int ulen = user.toString().length();*/
            Class<User> userClass = User.class;
            int length = userClass.getDeclaredFields().length;//获取实体类中的属性个数 //有多个属性对应数据库表中就有多少个字段
            data[i] = new Object[length-1];//给每一行对象赋值length个列
            for(int j = 0;j<length-1;j++){
                data[i][0] = user.getUsername();
                data[i][1] = user.getPassword();
            }
        }
        return data;
    }
    @DataProvider(name = "data")
    public static Object[][] datas(){
        Object[][] datas =  chooseAllCase();
        return datas;
    }

    //取出所有用例
    public static List<User> getAllCases(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_default);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        return users;
    }
    //判断用例数据是否存在
    public static Boolean isCaseNameExists(User queryRowData){
        if(queryRowData==null){
            throw new RuntimeException("用例数据不存在！");
        }else {
            return true;
        }
    }
}
