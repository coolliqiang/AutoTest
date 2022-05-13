package com.test.autotest.mapper;

import com.test.autotest.bean.RegisterInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegisterInfoMapper {
    /**
     * 查询所有用例
     */
    List<RegisterInfo> selectAll();

    /**
     * 添加用户
     */
    int insert(RegisterInfo registerInfo);

    /**
     * 通过id查询一条记录
     * @param id
     * @return
     */
    RegisterInfo selectOne(@Param("id") Integer id);

    RegisterInfo selectOneByCaseName(@Param("caseDesc") String caseDesc);
}
