package com.example.hellojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


@RestController
@RequestMapping("/test")
public class TestApiController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping
    String test(){
        System.out.println(member.toString());
        memberRepository.save(member);

        //엔티티 매니저 펙토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //엔티티 매니저 생성
        EntityManager em = emf.createEntityManager();
        //엔티티 매니저 트랜잭션 생성
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //객체를 생성한 상태(비영속)
        Member member1 = new Member();
        member1.setId(100L);
        member1.setName("회원");

        //객체를 저장한 상태(영속)
        em.persist(member);

        //회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
        //em.detach(member);

        //객체를 삭제한 상태(삭제)
        //em.remove(member);

        //커밋하는 순간 DB에 쿼리를 수행
        tx.commit();

        return "test";
    }
}
