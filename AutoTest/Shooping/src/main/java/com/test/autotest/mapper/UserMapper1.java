package com.test.autotest.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserMapper1 {
    /**
     * 删除测试数据
     */
    void deleteAll();

    /**
     * 删除某一条数据
     */
    void deleteOne(@Param("id") Integer id);
}
