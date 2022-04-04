package com.example.java8;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //lesson1. 함수형 인터페이스
        //FunctionalInterfaceImpl.run();

        //lesson1. 람다 표현식
        //LamdaImpl.run();

        //lesson2. 매소드 래퍼런스
        //MethodReferenceImpl.run();

        //
        //StreamServiceImpl.excute(); //스트림 API

        //
        //OptionalServiceImpl.excute();

        //
        //DateTimeServiceImpl.excute();

        //
        //AnnotationImpl.excute(); //어노테이션의 변화

        //
        //ParallelArraySortImpl.excute();

        //S
        //CompletableFutureImpl.excute();

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        //executorService.execute(()->System.out.println("ExecutorService Thread: "+Thread.currentThread().getName()));
//        executorService.submit(()->System.out.println("ExecutorService Thread1: "+Thread.currentThread().getName()));
//        executorService.submit(()->System.out.println("ExecutorService Thread2: "+Thread.currentThread().getName()));
//        executorService.submit(()->System.out.println("ExecutorService Thread3: "+Thread.currentThread().getName()));
//        executorService.submit(()->System.out.println("ExecutorService Thread4: "+Thread.currentThread().getName()));
//        executorService.submit(()->System.out.println("ExecutorService Thread5: "+Thread.currentThread().getName()));
//        executorService.submit(()->System.out.println("ExecutorService Thread6: "+Thread.currentThread().getName()));
//        executorService.submit(()->System.out.println("ExecutorService Thread7: "+Thread.currentThread().getName()));
//        executorService.submit(()->System.out.println("ExecutorService Thread8: "+Thread.currentThread().getName()));
//        executorService.submit(()->System.out.println("ExecutorService Thread9: "+Thread.currentThread().getName()));
//        executorService.submit(()->System.out.println("ExecutorService Thread10: "+Thread.currentThread().getName()));
//        //다음 작업이 들어올 때까지 대기하기 때문에 프로세스가 죽지 않는다.
//        //명시적으로 셧다운을 해야합니다.
//        executorService.shutdown();

//        long start = System.currentTimeMillis();
//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//                    System.out.println((System.currentTimeMillis()-start)/1000+"초가 지났습니다.");
//                    System.out.println("ScheduledExecutorService Thread: "+Thread.currentThread().getName());
//                }
//                ,3,2, TimeUnit.SECONDS);
//        //맨 처음 3초 후 실행 이후 2초마다 실행
//        Thread.sleep(10000);
//        System.out.println((System.currentTimeMillis()-start)/1000+"초가 지났습니다. shutdown");
//        scheduledExecutorService.shutdown();

//        long start = System.currentTimeMillis();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Callable<String> hello = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(2000L);
//                System.out.println((System.currentTimeMillis()-start)/1000+"초가 지났습니다.");
//                System.out.println(Thread.currentThread().getName());
//                return "Hello";
//            }
//        };
//
//        Future<String> future = executorService.submit(hello);
//        System.out.println("start status: "+future.isDone());
//        String h = future.get();// 블록킹콜
//        System.out.println(h);
//        System.out.println("end status: "+future.isDone());
//        Thread.sleep(10000);
//        executorService.shutdown();

        String lee = "leegunj";

        System.out.println(lee.charAt(0));
        System.out.println(lee.charAt(1));
        System.out.println(lee.charAt(2));
        System.out.println(lee.charAt(3));
        System.out.println(lee.length());


        for(int i=0;i<10;i++) {
            Thread thread = new Thread(() -> System.out.println("hello-"+Thread.currentThread().getName()));
            thread.start();
        }


        /**
         * 람다 표현식(Lambda Expressions)
         * 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
         * 코드를 줄일 수 있다.
         * 메소드 매개변수, 리턴 타입, 변수로 만들어 사용할 수도 있다.
         */

        //함수형 인터페이스를 인라인으로 구현한 특수한 형태의 오브젝트
        //자바는 객체지향 언어이기 때문에 이러한 특수한 형태를 메소드 파라미터로 전달하거나 리턴할 수 있다.
        //RunSomething runSomething = () -> System.out.println("Hello");
        //runSomething.doIt();

        /**
         * 자바에서 함수형 프로그래밍
         * 함수를 First class object로 사용할 수 있다.
         * 순수 함수 (Pure function)
         * - 사이드 이펙트 만들 수 없다. (함수 밖에 있는 값을 변경하지 못한다.)
         * - 함수 밖에 정의되어 있는 상태가 없다.
         * 고차 함수 (High-Order Function)
         * - 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수도 있다.
         * 불변성
         */

        /**
         * 같은 값을 넣었는데 같은 값이 않나오는 여지가 있으면 순수 함수가 아니다?
         */
//        int baseNum = 10;
//        RunSomething2 runSomething2 = num -> num + baseNum;
//        System.out.println(runSomething2.doIt(3));
//
//        //10 더하기 함수
//        Plus10 plus10 = new Plus10();
//        System.out.println(plus10.apply(1));
//
//        //2 곱하기 함수
//        Function<Integer, Integer> multiply2 = integer -> integer * 2;
//        System.out.println(multiply2.apply(20));
//
//        Function multiply2AndPlus10 = plus10.compose(multiply2);
//        System.out.println(multiply2AndPlus10.apply(10));
//
//        System.out.println(plus10.andThen(multiply2).apply(10));
//
////        int test2 = plus10.andThen(multiply2);
//
//        Supplier<Integer> supplier = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return 5;
//            }
//        };
//
//        System.out.println(supplier.get());
//
//        BinaryOperator<Integer> binaryOperator = (o, o2) -> o + o2;
//        System.out.println(binaryOperator.apply(1,2));
//
//        Greeting greeting = new Greeting("이근재");
//
//        System.out.println(greeting.hello("leegunj"));
//
//        UnaryOperator<String> hi = Greeting::hi;
//        System.out.println(hi.apply("leegunj"));
//
//        Supplier<Greeting> sGreeting = Greeting::new;
//        System.out.println(sGreeting.get().hello("leegunj"));
//
//        practiceFunctionalInterface();
//        practiceMethodReference();
//        printDefaultStaticMethod();
//        printStream();
    }

    static void practiceFunctionalInterface() {
        System.out.println(">> practiceFunctionalInterface Start!!!");

        //입력값 없이 결과
        Supplier<Integer> supplier = () -> 10;

        //하나의 매개변수와 하나의 결과
        Function<Integer,Integer> function = i -> i+1;

        //위의 펑션 함수형 인터페이스와 다른점이 무엇일까?
        //입력값과 결과값의 타입이 같은 경우 줄여서 사용할 수 있다.
        UnaryOperator<Integer> unaryOperator = i -> i+10;
    }



    static void printStream(){
        System.out.println("Stream start !!!");
        List<String> list = new ArrayList<>();
        list.add("lee");
        list.add("sin");
        list.add("kim");
        list.add("park");

        System.out.println("===================1");
        list.stream().map(s->{
            //중개 오퍼레이션이므로 종료 오퍼레이션이 호출되기 전까지는 동작하지 않는다.
            System.out.println("스트림 대문자 처리: "+s.toUpperCase());
            System.out.println(s+" "+Thread.currentThread().getName());
//            스트림 대문자 처리: LEE
//            lee main
//            스트림 대문자 처리: SIN
//            sin main
//            스트림 대문자 처리: KIM
//            kim main
//            스트림 대문자 처리: PARK
//            park main
            return s.toUpperCase();
        }).collect(Collectors.toList());

        System.out.println("===================2");
        //원본 소스는 변경되지 않는다.
        list.forEach(System.out::println);

        //손쉽게 병렬처리를 할 수 있다.
        List<String> result = list
                .parallelStream()
                .filter(s -> {
                    System.out.println(s+" "+Thread.currentThread().getName());
//                    kim main
//                    park ForkJoinPool.commonPool-worker-5
//                    lee ForkJoinPool.commonPool-worker-7
//                    sin ForkJoinPool.commonPool-worker-3
                    return s.startsWith("l");
                })
                .collect(Collectors.toList());
        System.out.println("test===");
        System.out.println(result.toString());
    }
}
