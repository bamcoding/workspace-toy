package com.example.java8to11.annotation;

import java.util.Arrays;

@Chicken("양념")
@Chicken("마늘간장")
public class AnnotationImpl {
    public static void excute() {
        ChickenContainer chickenContainer = AnnotationImpl.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c-> System.out.println(c.value()));
    }

}
