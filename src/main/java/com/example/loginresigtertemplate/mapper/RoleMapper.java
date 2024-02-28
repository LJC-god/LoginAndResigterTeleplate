package com.example.loginresigtertemplate.mapper;

import com.example.loginresigtertemplate.domain.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer cardId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer cardId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}