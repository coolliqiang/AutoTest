package com.vip.dao;

import com.vip.domain.User;

import java.util.List;

/**
 * 用户持久层
 */
public interface UserDao {
    /**
     * 查询所有的用户
     * @return
     */
    public List<User> queryAll();
}
