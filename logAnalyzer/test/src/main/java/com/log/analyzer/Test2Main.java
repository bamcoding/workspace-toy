package com.log.analyzer;

import java.util.Scanner;

public class Test2Main {
    static int N,M;
    static int picture[][] = new int[101][101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i=0; i<N; i++) {
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int destX = sc.nextInt();
            int destY = sc.nextInt();
            for(int x=startX; x<=destX; x++) {
                for(int y=startY; y<=destY ; y++) {
                    picture[x][y] += 1;
                }
            }
        }

        int resultCount = 0;
        for(int x=1; x<=100; x++) {
            for(int y=1; y<=100; y++) {
                if(picture[x][y] > M) resultCount++;
            }
        }
        System.out.println(resultCount);
    }
}
