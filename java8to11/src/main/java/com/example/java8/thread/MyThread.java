package com.example.java8.thread;

/*
* 자바에서 쓰레드를 사용하는 방법
* 1. 스레드를 상속받은 클래스를 사용
* 2. 함수형 인터페이스 런어블을 사용
*
**/
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
    }

    @Override
    public synchronized void start() {
        super.start();
    }
}
