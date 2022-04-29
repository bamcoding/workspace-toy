package com.log.algorithm.greedy;

public class GreedyImpl {
    public static int run(int n) {
        int result = 0;

        result += n / 500;
        n = n%500;

        result += n / 100;
        n = n%100;

        result += n / 50;
        n = n%50;

        result += n / 10;
        n = n%10;

        return result;
    }
}
