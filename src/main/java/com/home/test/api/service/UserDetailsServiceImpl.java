package com.home.test.api.service;

import com.home.test.api.exception.AuthenticationException;
import com.home.test.api.exception.UserNotFoundException;
import com.home.test.api.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    /*@Autowired
    private UserService userService;*/

    /*public UserDetailsServiceImpl() {
        System.out.println("----------------------------------------------------------------------------------------");
    }

    @Override
    public UserEntity authenticate(String email, String password) throws UserNotFoundException, AuthenticationException {
        final UserEntity user = new UserEntity();//userService.getByEmail(email);
        user.setUsername("sara@yahoo.com");
        user.setPassword("123");
        if (!user.getUsername().equals(email)) {
            throw new AuthenticationException("User with this email does not exist.");
        } else {
//            String encryptedPassword = EncryptionUtils.encrypt(password);
            if (!user.getPassword().equals(password))
                throw new AuthenticationException("The pair of username/password is not valid!");
            else
                return user;
        }
    }*/

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        final UserDetails user = new UserEntity("sarshad","$2a$10$onxhNh/UDXa96Ac6hO/lleDJPQVT01QZ8NF2ESqKk.tlMiPM/aoFG", "sa","arshad","USER");//userService.getByEmail(email);
        if (user==null || !user.getUsername().equals(s)) {
            throw new AuthenticationException("User with this email does not exist.");
        }
        return user;
    }
}
