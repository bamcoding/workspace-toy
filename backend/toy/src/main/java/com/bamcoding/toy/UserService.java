package com.bamcoding.toy;

public interface UserService {
    UserEntity create(final UserEntity userEntity);

    UserEntity getByCredentials(String email, String password);
}
