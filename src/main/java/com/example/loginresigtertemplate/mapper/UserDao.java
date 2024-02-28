package com.example.loginresigtertemplate.mapper;

import com.example.loginresigtertemplate.daomain.User;

public interface UserDao {
    int deleteByPrimaryKey(Integer adminId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}