package com.home.test.api.service;

import com.home.test.api.exception.UserNotFoundException;
import com.home.test.api.model.UserEntity;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by Sara on 2018/08/12.
 */
public interface AuthenticationService {

    UserEntity authenticate(String email, String password) throws UserNotFoundException, AuthenticationException;

}
