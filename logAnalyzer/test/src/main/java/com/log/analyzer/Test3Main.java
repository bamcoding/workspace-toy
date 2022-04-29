package com.log.analyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test3Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();
        numbers = getNumListByMod(N,numbers);
        numbers = numbers.stream().sorted().collect(Collectors.toList());

        String result = "";
        for(int i=numbers.size()-1;i>=0;i--){
            result += numbers.get(i);
        }

        System.out.println(Integer.valueOf(result));
    }

    static List<Integer> getNumListByMod(int N, List<Integer> list) {
        list.add(N%10);

        if(N>10){
            return getNumListByMod(N/10,list);
        }

        return list;
    }
}
