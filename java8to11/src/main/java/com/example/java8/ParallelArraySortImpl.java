package com.example.java8;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ParallelArraySortImpl {

    static void excute() {
        int size = 1500;
        int[] numbers = new int[size];
        Random random = new Random();

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        long start = System.nanoTime();
        Arrays.sort(numbers);
        System.out.println("serial sorting took " + (System.nanoTime() - start));

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(numbers);
        System.out.println("parallel sorting took " + (System.nanoTime() - start));

//        serial    sorting took 1258500
//        parallel  sorting took 1414084
    }
}