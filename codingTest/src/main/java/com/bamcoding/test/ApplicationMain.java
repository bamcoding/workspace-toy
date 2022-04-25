package com.bamcoding.test;

import java.util.Scanner;

class ApplicationMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(getFibonachi(0, 1, n));

    }

    static long getFibonachi(int f, int s, int n){
        System.out.println(f);
        if(n <= 0) return 0;
        if(n == 1) return 1;
        return f + getFibonachi(s,f+s,n-1);
    }
}
