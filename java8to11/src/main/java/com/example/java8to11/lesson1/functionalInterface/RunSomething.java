package com.example.java8to11.lesson1.functionalInterface;

/**
 * 함수형 인터페이스
 * 추상 메소드가 하나만 있으면 함수형 인터페이스
 * SAM Single Abstract Method 인터페이스
 * FunctionInterface 어노테이션을 가지고 있는 인터페이스
 *
 * 자바8 부터 public을 생략할 수 있다.
 */
//
@FunctionalInterface
public interface RunSomething {

    //추상 메소드
    void doIt();

    static void printName(){
        System.out.println("static");
    }

    default void printAge(){
        System.out.println("default");
    }

}
