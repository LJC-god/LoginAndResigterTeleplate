package com.example.loginresigtertemplate.filtera;
import com.example.loginresigtertemplate.daomain.SecurityUser;
import com.example.loginresigtertemplate.daomain.User;
import com.example.loginresigtertemplate.security.TokenManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    private TokenManager tokenManager;
//    private IRedisService redisService;
    private AuthenticationManager authenticationManager;

    public TokenLoginFilter(TokenManager tokenManager, AuthenticationManager authenticationManager) {
        this.tokenManager = tokenManager;
//        this.redisService = redisService;
        this.authenticationManager = authenticationManager;
        this.setPostOnly(false);
        //设置登录路径
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList()));
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //认证成功，得到认真成功之后用户信息
        SecurityUser user = (SecurityUser) authResult.getPrincipal();
        User currentUserInfo = user.getCurrentUserInfo();
        String username = currentUserInfo.getUsername();


        //根据用户名生成token
        String token = tokenManager.createToken(username);
//        String usernameKey = String.format(RedisConstant.AUTH_USER_KEY, username);
        //把用户名和用户权限列表放到redis中去
//        redisService.set(usernameKey, user.getPermissionValueList());
        HashMap hashMap = new HashMap();
        currentUserInfo.setPassword("");
        currentUserInfo.setSalt("");
        hashMap.put("token", token);
        hashMap.put("user", currentUserInfo);
//        ResponseUtil.out(response, R.ok("认证成功").data("data", hashMap));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
        if ("org.springframework.security.authentication.BadCredentialsException".equals(failed.getClass().getName())) {
//            ResponseUtil.out(response, R.error(AuthMessageConstant.USERNAME_PASSWORD_ERROR));
        } else {
//            ResponseUtil.out(response, R.error(failed.getMessage()));
        }
    }
}
