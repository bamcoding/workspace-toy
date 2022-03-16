package com.example.java8to11.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    //더 자바 코드를 조작하는 다양한 방법
    //Retention 전략

    String value();

}
