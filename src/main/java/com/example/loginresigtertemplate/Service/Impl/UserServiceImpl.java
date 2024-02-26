package com.example.loginresigtertemplate.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.loginresigtertemplate.Domain.User;
import com.example.loginresigtertemplate.Service.UserService;
import com.example.loginresigtertemplate.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 梁嘉诚
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-02-26 15:40:27
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




