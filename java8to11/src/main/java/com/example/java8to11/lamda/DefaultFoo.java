package com.example.java8to11.lamda;

public class DefaultFoo implements Foo{

    String name;

    @Override
    public void printName() {
        System.out.println(getName());
    }

    public DefaultFoo(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
