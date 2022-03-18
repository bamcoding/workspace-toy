package com.example.java8.optional;

import com.example.java8.vo.OnlineClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalServiceImpl {

    public static void excute() {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot",true));
        springClasses.add(new OnlineClass(5, "rest api development",false));

//        OnlineClass spring_boot = new OnlineClass(1,"spring boot",true);
//        Progress progress = spring_boot.getProgress();
//
//        //널을 리턴하는 것 자체가 문제다.
//        //자바8 이전에 클라이언트 로직에서 사용하는 방법
//        if(progress != null) {
//            System.out.println(progress.getStudyDuration());
//        }

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc->oc.getTitle().startsWith("jpa"))
                .findFirst();

        boolean present = optional.isPresent();
        System.out.println(present);

//        OnlineClass onlineClass1 = onlineclass.get();
//        System.out.println(onlineClass1.getTitle());

        //있으면 꺼내오고 없으면 새로운 클래스를 만들어라
//        OnlineClass onlineClass = optional.orElse(createNewClass());
        OnlineClass onlineClass = optional.orElseGet(OptionalServiceImpl::createNewClass);
        System.out.println(onlineClass.getTitle());

        System.out.println(optional.map(OnlineClass::getId).get());

    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
