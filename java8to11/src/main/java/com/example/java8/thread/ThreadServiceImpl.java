package com.example.java8.thread;

public class ThreadServiceImpl {

    public void run(){

        MyThread myThread = new MyThread();
        myThread.start();

        Thread rThread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
