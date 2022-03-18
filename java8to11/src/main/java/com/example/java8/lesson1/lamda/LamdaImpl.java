package com.example.java8.lesson1.lamda;

import com.example.java8.lesson1.functionalInterface.RunSomething;

public class LamdaImpl {
    public static void run(){
        RunSomething runSomething = () -> System.out.println("Hello!");
    }
}
