package com.example.loginresigtertemplate.config;

import com.example.loginresigtertemplate.filtera.TokenAuthFilter;
import com.example.loginresigtertemplate.filtera.TokenLoginFilter;
import com.example.loginresigtertemplate.security.TokenManager;
import com.example.loginresigtertemplate.security.UnauthEntryPoint;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import javax.sql.DataSource;
import jakarta.servlet.Filter;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://gz-cdb-ipst7wg5.sql.tencentcdb.com:63410/wiki")
                .username("root")
                .password("Aa6381186.")
                .build();
    }

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private SecurityUserService userService;

    // 配置Spring Security的过滤器链
    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 配置异常处理器，用于处理未经授权的请求
                .exceptionHandling()
                .authenticationEntryPoint(new UnauthEntryPoint())
                .and()
                // 配置跨域支持
                .cors()
                .and()
                // 禁用CSRF保护
                .csrf()
                .disable()
                // 配置请求授权规则
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                // 配置登出功能
                .logout()
                .logoutUrl("/logout")
                .and()
                // 添加自定义的认证过滤器
                .addFilter((Filter) new TokenLoginFilter(tokenManager, http.getSharedObject(AuthenticationManager.class)))
                // 添加自定义的授权过滤器
                .addFilter((Filter) new TokenAuthFilter(http.getSharedObject(AuthenticationManager.class), tokenManager))
                // 启用HTTP基本认证
                .httpBasic();

        return http.build();
    }

    // 提供密码编码器的Bean
    @Bean
    public  static PasswordEncoder passwordEncoder() {
        String encodingId = "bcrypt";
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(encodingId, new BCryptPasswordEncoder());
        encoders.put("ldap", new org.springframework.security.crypto.password.LdapShaPasswordEncoder());
        encoders.put("MD4", new org.springframework.security.crypto.password.Md4PasswordEncoder());
        encoders.put("MD5", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("MD5"));
        encoders.put("noop", org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance());
        encoders.put("SHA-1", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-1"));
        encoders.put("SHA-256", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-256"));
        encoders.put("sha256", new org.springframework.security.crypto.password.StandardPasswordEncoder());
        return new DelegatingPasswordEncoder(encodingId, encoders);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory;
    }

}
