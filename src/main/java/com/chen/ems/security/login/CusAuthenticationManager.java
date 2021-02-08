package com.chen.ems.security.login;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: CHENLIHUI
 * @Description: 自定义认证管理器
 * @Date: Create in 15:12 2020/8/11
 */
@Component
public class CusAuthenticationManager implements AuthenticationManager {

    private final AdminAuthenticationProvider adminAuthenticationProvider;



    public CusAuthenticationManager(AdminAuthenticationProvider adminAuthenticationProvider) {
        this.adminAuthenticationProvider = adminAuthenticationProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication result = adminAuthenticationProvider.authenticate(authentication);
        if (Objects.nonNull(result)) {
            return result;
        }
        throw new ProviderNotFoundException("Authentication failed!");
    }
}
