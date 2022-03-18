package com.example.java8to11.lesson1.functionalInterface;

import java.util.function.Function;

public class FunctionalInterfaceImpl {
    public static void excute(){
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello!");
            }
        };

        Function<Integer,Integer> function = i -> i+10;
        System.out.println(function);
    }
}
