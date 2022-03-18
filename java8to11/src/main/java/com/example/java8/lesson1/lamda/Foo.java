package com.example.java8.lesson1.lamda;


public interface Foo {

    void printName();

    /**
     * @implSpec 이 구현체는 name을 대문자로 바꿔 출력합니다.
     */
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    String getName();
}
