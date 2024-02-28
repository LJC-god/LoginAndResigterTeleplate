package com.example.loginresigtertemplate.security;/*
 *@author LJCheng
 *@version 1.0
 *
 */

import org.springframework.security.crypto.password.PasswordEncoder;


public class DefaultPasswordEncoder implements PasswordEncoder {

    public DefaultPasswordEncoder() {
    }

    //进行MD5加密
    @Override
    public String encode(CharSequence charSequence) {
//        return MD5.encrypt(charSequence.toString());
        return "MD5.encrypt(charSequence.toString())";
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
//        return s.equals(MD5.encrypt(charSequence.toString()));
        return true;
    }
}
