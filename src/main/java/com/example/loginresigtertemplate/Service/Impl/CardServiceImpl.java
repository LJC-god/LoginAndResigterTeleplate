package com.example.loginresigtertemplate.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.loginresigtertemplate.Domain.Card;
import com.example.loginresigtertemplate.Service.CardService;
import com.example.loginresigtertemplate.mapper.CardMapper;
import org.springframework.stereotype.Service;

/**
 * @author 梁嘉诚
 * @description 针对表【card】的数据库操作Service实现
 * @createDate 2024-02-26 15:40:27
 */
@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card>
        implements CardService {

}




