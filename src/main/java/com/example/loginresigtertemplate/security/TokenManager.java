package com.example.loginresigtertemplate.security;/*
 *@author LJCheng
 *@version 1.0
 *
 */

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenManager {

    /**
     * 设置token有效时长 两个星期
     */
    private final long tokenExpiration = 14 * 24 * 60 * 60 * 1000;

    /**
     * 编码密钥
     */
    private String tokenSignKey = "123456";

    /**
     * 使用JWT根据用户名生成token
     */
    public String createToken(String username) {
        String token = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(SignatureAlgorithm.HS512, tokenSignKey).compressWith(CompressionCodecs.GZIP).compact();
        return token;
    }

    /**
     * 根据token字符串得到用户信息
     */
    public String getUserInfoFromToken(String token) {
        String userInfo = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody().getSubject();
        return userInfo;
    }

    /**
     * 删除token
     */
    public void removeToken(String token) {

    }

}