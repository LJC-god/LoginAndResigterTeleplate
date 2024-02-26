package com.example.loginresigtertemplate.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.loginresigtertemplate.Domain.Admin;
import com.example.loginresigtertemplate.Service.AdminService;
import com.example.loginresigtertemplate.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
* @author 梁嘉诚
* @description 针对表【admin】的数据库操作Service实现
* @createDate 2024-02-26 15:40:27
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

}




