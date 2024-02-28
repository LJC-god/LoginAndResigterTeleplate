package com.example.loginresigtertemplate.config;
/*
 *@author LJCheng
 *@version 1.0
 *
 */

import com.example.loginresigtertemplate.daomain.SecurityUser;
import com.example.loginresigtertemplate.daomain.User;
import com.example.loginresigtertemplate.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
//        User user = userService.loadByUsername(username);
        User user = new User();
        if (user == null) {
            throw new AccountExpiredException("123123");
        }
        SecurityUser securityUser = new SecurityUser(user);
        if (!securityUser.isEnabled()) {
            throw new DisabledException("账户被禁用");
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException("账户被锁定");
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException("账户过期");
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("证书过期");
        }


        return securityUser;
    }
}

