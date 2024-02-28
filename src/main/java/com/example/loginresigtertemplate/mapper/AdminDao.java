package com.example.loginresigtertemplate.mapper;

import com.example.loginresigtertemplate.daomain.Admin;

public interface AdminDao {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}