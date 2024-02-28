package com.example.loginresigtertemplate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebCORSConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 是否发送Cookie
                .allowCredentials(true)
                // 放行哪些原始域
                .allowedOrigins("http://localhost:5173")
                // 允许的请求方法
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                // 允许的请求头
                .allowedHeaders("*")
                // 允许暴露的响应头
                .exposedHeaders("*")
                // 预检请求的缓存时间（单位：秒）
                .maxAge(3600);
    }
}
