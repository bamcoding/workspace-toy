package com.bamcoding.toy;

import com.bamcoding.toy.todo.dto.ResponseDTO;
import com.bamcoding.toy.todo.dto.TodoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("pathVariable/{id}")
    public String test(@PathVariable(required = false) int id){
        return "Hello World! pathVariable ID "+id;
    }

    @GetMapping("/requestParam")
    public String requestParam(@RequestParam(required = false) int id){
        return "Hello World! requestParam ID "+id;
    }

    @GetMapping("/requestBody")
    public String requestBody(@RequestBody(required = false) TodoDTO todoDTO){
        return "Hello World! requestBody title "+todoDTO.getTitle();
    }

    @GetMapping("/ResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity(){
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And you got 400!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/decode/base64")
    @ResponseBody
    public String decodeBase64(@RequestParam(name = "token") String token) {
        System.out.println("token : "+token);

        Base64Utils.decodeFromUrlSafeString(token);

        System.out.println("token : "+token);

        byte[] decode = Base64.getDecoder().decode(token.getBytes(StandardCharsets.UTF_8));

        String result = new String(decode, StandardCharsets.UTF_8);

        System.out.println("result : "+ result);

        return result;
    }
}
