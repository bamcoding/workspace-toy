package com.bamcoding.toy;

import com.bamcoding.toy.todo.dto.ResponseDTO;
import com.bamcoding.toy.todo.dto.TodoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

}
