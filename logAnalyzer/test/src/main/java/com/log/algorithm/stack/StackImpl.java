package com.log.algorithm.stack;

import java.util.Stack;

public class StackImpl {
    public static void run() {
        Stack<Integer> s = new Stack<>();

        System.out.println("stack");
        s.push(5);
        s.push(1);
        s.push(4);
        s.push(2);
        s.push(10);

        while(!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
