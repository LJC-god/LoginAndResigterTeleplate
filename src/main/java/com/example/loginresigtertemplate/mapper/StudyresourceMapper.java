package com.example.loginresigtertemplate.mapper;

import com.example.loginresigtertemplate.domain.Studyresource;

public interface StudyresourceMapper {
    int deleteByPrimaryKey(Integer cardId);

    int insert(Studyresource record);

    int insertSelective(Studyresource record);

    Studyresource selectByPrimaryKey(Integer cardId);

    int updateByPrimaryKeySelective(Studyresource record);

    int updateByPrimaryKey(Studyresource record);
}