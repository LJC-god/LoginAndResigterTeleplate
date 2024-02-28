package com.example.loginresigtertemplate.mapper;

import com.example.loginresigtertemplate.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer cardId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer cardId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}