package com.example.loginresigtertemplate.security;/*
 *@author LJCheng
 *@version 1.0
 *
 */


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 认证失败
 */
public class UnauthEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e)  {

//        ResponseUtil.out(httpServletResponse, R.error());
    }


//    @Override
//    public void commence(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        e.printStackTrace();
//    }
}
