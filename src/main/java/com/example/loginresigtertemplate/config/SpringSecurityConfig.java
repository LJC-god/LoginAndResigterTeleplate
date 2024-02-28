/*
package com.example.loginresigtertemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    //登录权限
//游客只能浏览首页/
//用户可以浏览所有页面除了/admin以及/admin/**
//管理员可以浏览所有的/admin以及/admin/**
//注销权限
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll() // 允许所有用户（包括未登录用户）访问主页
                .antMatchers("/admin/**").hasRole("ADMIN") // 只有管理员可以访问管理员页面
                // 其他所有请求需要登录
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") // 指定登录页面
                .permitAll() // 允许用户访问登录页面
                .and()
                .logout()
                .permitAll(); // 允许用户注销
        //登录成功后跳转到主页
        http.formLogin(fromlogin -> fromlogin
                .loginPage("/login") // 自定义登录页面
                .permitAll()
                .loginProcessingUrl("/login") // 自定义登录请求路径
                .defaultSuccessUrl("/home", true) // 登录成功后跳转页面
                .failureUrl("/login?error=true") // 登录失败后跳转页面
        );
        //关闭csrf
        http.csrf().disable();
        //注销
        http.logout(logout -> logout
                .logoutUrl("/logout") // 自定义注销请求路径
                .logoutSuccessUrl("/") // 注销成功后跳转页面
        );
        return http.build();
    }
}
*/
