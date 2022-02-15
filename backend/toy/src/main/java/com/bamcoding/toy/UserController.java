package com.bamcoding.toy;

import com.bamcoding.toy.common.ResponseDTO;
import com.bamcoding.toy.security.TokenProvider;
import com.bamcoding.toy.user.UserDTO;
import com.bamcoding.toy.user.UserEntity;
import com.bamcoding.toy.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        log.info("call signup");
        try {
            UserEntity user = UserEntity.builder()
                    .email(userDTO.getEmail())
                    .username(userDTO.getUsername())
                    .password(userDTO.getPassword())
                    .build();

            UserEntity registeredUser = userService.create(user);
            UserDTO responseUserDTO = UserDTO.builder()
                    .email(registeredUser.getEmail())
                    .id(registeredUser.getId())
                    .username(registeredUser.getUsername())
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @GetMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO) {
        log.info("call signin");
        try{
            UserEntity user = userService.getByCredentials(userDTO.getEmail(),userDTO.getPassword(), passwordEncoder);

            if(user != null){
                //토큰 생성
                final String token = tokenProvider.create(user);

                final UserDTO responseUserDTO = UserDTO.builder()
                        .email(user.getEmail())
                        .id(user.getId())
                        .token(token)
                        .build();
                return ResponseEntity.ok().body(responseUserDTO);
            } else {
                ResponseDTO responseDTO = ResponseDTO.builder().error("Login failed").build();
                return ResponseEntity.badRequest().body(responseDTO);
            }
        } catch(Exception e) {
            e.printStackTrace();
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
