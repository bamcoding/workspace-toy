package com.bamcoding.toy.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String token;
    private String email;
    private String username;
    private String password;
    private String id;

    public UserDTO(final UserEntity entity) {
        this.email = entity.getEmail();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.id = entity.getId();
    }

    public static UserEntity toEntity(final UserDTO dto){
        UserEntity entity = new UserEntity();
        return entity;
    }
}
