package com.example.loginresigtertemplate.filtera;

import com.example.loginresigtertemplate.security.TokenManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
@author XiHai ShengGe
*/
public class TokenAuthFilter extends BasicAuthenticationFilter {

    private TokenManager tokenManager;
//    private IRedisService redisService;

    public TokenAuthFilter(AuthenticationManager authenticationManager, TokenManager tokenManager) {
        super(authenticationManager);
        this.tokenManager = tokenManager;
//        this.redisService = redisService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取当前认证成功的用户权限信息
        try {
            UsernamePasswordAuthenticationToken authRequest = getAuthention(request);
            //判断如果有权限授权信息，就放到权限上下文中
//            if (ObjectUtil.isNotNull(authRequest)) {
//                SecurityContextHolder.getContext().setAuthentication(authRequest);
//            }
            chain.doFilter(request, response);
        } catch (Exception e) {
//            ResponseUtil.out(response, R.error("认证失败,token过期或者无效!"));
        }
    }

    public UsernamePasswordAuthenticationToken getAuthention(HttpServletRequest request) {
        //从header中获取token
//        String token = request.getHeader("token");
//        if (ObjectUtil.isNotNull(token)) {
//            String username = tokenManager.getUserInfoFromToken(token);
//            String usernameKey = String.format(RedisConstant.AUTH_USER_KEY, username);
//            //从redis中获取权限列表信息
//            Set<String> permissionsValueList = (Set<String>) redisService.get(usernameKey);
//            if (ObjectUtil.isEmpty(permissionsValueList)) {
//                permissionsValueList = new LinkedHashSet<>();
//            }
//            Collection<GrantedAuthority> authority = new ArrayList<>();
//            for (String permissionsValue : permissionsValueList) {
//                SimpleGrantedAuthority auth = new SimpleGrantedAuthority(permissionsValue);
//                authority.add(auth);
//            }
//            return new UsernamePasswordAuthenticationToken(username, token, authority);
//        }
        return null;
    }
}
