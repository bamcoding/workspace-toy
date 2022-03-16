package com.example.hellojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestApiController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping
    String test(){
        Member member = Member.builder()
                .id(1L)
                .name("스프링")
                .build();
        System.out.println(member.toString());
        memberRepository.save(member);

        return "test";
    }
}
