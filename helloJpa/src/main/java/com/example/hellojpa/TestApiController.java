package com.example.hellojpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestApiController {
    @GetMapping
    String test(){
        return "test";
    }
}
