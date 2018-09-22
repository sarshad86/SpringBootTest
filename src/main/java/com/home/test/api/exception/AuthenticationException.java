package com.home.test.api.exception;

/**
 * Created by Sara on 2018/08/12.
 */
public class AuthenticationException extends org.springframework.security.core.AuthenticationException {
    public AuthenticationException(String msg) {
        super(msg);
    }
}
