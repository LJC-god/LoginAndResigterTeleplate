package com.example.loginresigtertemplate.mapper;

import com.example.loginresigtertemplate.daomain.Studyresource;

public interface StudyresourceDao {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Studyresource record);

    int insertSelective(Studyresource record);

    Studyresource selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Studyresource record);

    int updateByPrimaryKey(Studyresource record);
}