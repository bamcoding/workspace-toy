package com.bamcoding.toy.user;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserService {
    UserEntity create(final UserEntity userEntity);

    UserEntity getByCredentials(String email, String password, PasswordEncoder passwordEncoder);
}
