package com.test.autotest.mapper;

import com.test.autotest.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 查询所有用例
     */
    List<User> selectAll();

    /**
     * 添加用户
     */
    int insert(User user);

    /**
     * 通过id查询一条记录
     * @param id
     * @return
     */
    User selectOne(@Param("id") Integer id);
}
