package com.example.java8to11.stream;

import com.example.java8to11.vo.OnlineClass;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamServiceImpl {

    public static void excute(){
        List<OnlineClass> classList = new ArrayList<>();
        classList.add(new OnlineClass(1, "spring boot",true));
        classList.add(new OnlineClass(2, "spring data jpa",true));
        classList.add(new OnlineClass(3, "spring mvc",true));
        classList.add(new OnlineClass(4, "spring",false));
        classList.add(new OnlineClass(5, "spring core",true));
        classList.add(new OnlineClass(6, "rest api development",false));

        classList.forEach(onlineClass -> System.out.println(onlineClass.getTitle()));

        //spring으로 시작하는 수업
        System.out.println("\n1. spring 으로 시작하는 수업");
        classList.stream()
            .filter(oc -> oc.getTitle().startsWith("spring"))
            .forEach(oc->System.out.println(oc.getTitle()));

        //close 되지 않는 수업
        System.out.println("\n2. close 되지 않는 수업");
        classList.stream()
            .filter(Predicate.not(OnlineClass::isClosed))
            .forEach(s-> System.out.println(s.getTitle()));

        //수업 이름만 모아서 스트림 만들기
        System.out.println("\n3. 수업 이름만 모아서 스트림 만들기");
        classList.stream()
            .map(oc->oc.getTitle())
            .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Jave Test",true));
        javaClasses.add(new OnlineClass(7, "The Java Code manipulation",true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11",false));

        List<List<OnlineClass>> leeEvents = new ArrayList<>();
        leeEvents.add(classList);
        leeEvents.add(javaClasses);

        System.out.println("\n1. 두 수업 목록에 들어있는 모든 수업 아이디 출력");
        leeEvents.stream()
                .flatMap(Collection::stream)//list -> list.stream()
                .forEach(oc-> System.out.println(oc.getId()));

        System.out.println("\n10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10 뺴고 최대 10개 까지만 출력");
        Stream.iterate(10,i->i+1)
                .skip(10)
                .limit(10)
                .forEach(i-> System.out.println(i));

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        System.out.println(javaClasses.stream().anyMatch(jc->jc.getTitle().contains("Test")));

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        List<String> result = classList.stream()
                .map(OnlineClass::getTitle)
                .filter(t -> t.contains("spring"))
                .collect(Collectors.toList());
        result.forEach(System.out::println);











    }
}
