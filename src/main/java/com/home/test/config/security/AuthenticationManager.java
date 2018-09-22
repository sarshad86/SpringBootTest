/*
package com.home.test.config;

import com.home.test.api.exception.AuthenticationException;
import com.home.test.api.exception.UserNotFoundException;
import com.home.test.api.model.UserEntity;
import com.home.test.api.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

*/
/**
 * Created by Sara on 2018/09/14.
 *//*

@Component
public class AuthenticationManager implements AuthenticationProvider {

    private final static Logger LOGGER = LoggerFactory.getLogger(AuthenticationManager.class);

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (null != authentication && authentication.isAuthenticated()) {
            return authentication;
        }
        final String identifier = (String) authentication.getPrincipal();
        final String password = (String) authentication.getCredentials();
        LOGGER.info("Attempting to log in user " + identifier);
        UserEntity user;
        try {
            user = authenticationService.authenticate(identifier, password);
        } catch (UserNotFoundException e) {
            throw new AuthenticationException("user not found");
        }
        return new UsernamePasswordAuthenticationToken(user, password, Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
*/
