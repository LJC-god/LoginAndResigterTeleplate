package com.example.loginresigtertemplate.mapper;

import com.example.loginresigtertemplate.daomain.Role;

public interface RolaDao {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}