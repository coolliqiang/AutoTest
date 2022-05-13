package com.test.autotest.util;

import com.test.autotest.bean.RegisterInfo;
import com.test.autotest.mapper.RegisterInfoMapper;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.DataProvider;

import java.util.List;

import static com.test.autotest.util.MyBatisUtil.MapperConfigXMLFileName_default;

public class DataUtils {
    private static Object[][] chooseAllCase(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_default);
        RegisterInfoMapper mapper = sqlSession.getMapper(RegisterInfoMapper.class);
        List<RegisterInfo> registerInfos = mapper.selectAll();
        Object[][] data = new Object[registerInfos.size()][];
        for(int i = 0; i< registerInfos.size(); i++){
            RegisterInfo registerInfo = registerInfos.get(i);
            /* int ulen = registerInfo.toString().length();*/
            Class<RegisterInfo> userClass = RegisterInfo.class;
            int length = userClass.getDeclaredFields().length;//获取实体类中的属性个数 //有多个属性对应数据库表中就有多少个字段
            data[i] = new Object[length-1];//给每一行对象赋值length个列
            for(int j = 0;j<length-1;j++){
                data[i][0] = registerInfo.getUsername();
                data[i][1] = registerInfo.getPassword();
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
    public static List<RegisterInfo> getAllCases(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(MapperConfigXMLFileName_default);
        RegisterInfoMapper mapper = sqlSession.getMapper(RegisterInfoMapper.class);
        List<RegisterInfo> registerInfos = mapper.selectAll();
        return registerInfos;
    }
    //判断用例数据是否存在
    public static Boolean isCaseNameExists(RegisterInfo queryRowData){
        if(queryRowData==null){
            throw new RuntimeException("用例数据不存在！");
        }else {
            return true;
        }
    }

}
