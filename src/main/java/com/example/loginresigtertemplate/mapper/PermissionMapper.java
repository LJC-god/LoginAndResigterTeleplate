package com.example.loginresigtertemplate.mapper;

import com.example.loginresigtertemplate.domain.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer cardId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer cardId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}