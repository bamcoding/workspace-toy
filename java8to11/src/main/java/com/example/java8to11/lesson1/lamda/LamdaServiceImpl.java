package com.example.java8to11.lesson1.lamda;

import com.example.java8to11.lesson1.functionalInterface.RunSomething;

public class LamdaServiceImpl {
    public static void excute(){
        RunSomething runSomething = () -> System.out.println("Hello!");
    }
}
