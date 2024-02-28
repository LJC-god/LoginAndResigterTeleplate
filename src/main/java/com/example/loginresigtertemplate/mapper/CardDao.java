package com.example.loginresigtertemplate.mapper;

import com.example.loginresigtertemplate.daomain.Card;

public interface CardDao {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Card record);

    int insertSelective(Card record);

    Card selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);
}