package com.log.analyzer;

import java.util.ArrayList;
import java.util.List;

public class Test4Main {

    static List<Integer> list = new ArrayList<>();
    static List<Integer> pathList = new ArrayList<>();

    public static void main(String[] args) {
        int testN1 = 16;
        int testN2 = 19;

        getResult(testN1);
        getResult(testN2);
    }

    static void getResult(int N){
        int number = 0;
        while(true){
            for(int i=0;i<10;i++){
                String strResult = (number + i) + "";
                int sum = 0;
                for(int ci=0;ci<strResult.length();ci++){
                    sum+=strResult.charAt(ci) - '0';
                }
                if (N==sum){
                    System.out.println(strResult);
                    return;
                }
            }
            number+=10;
        }
    }
}
