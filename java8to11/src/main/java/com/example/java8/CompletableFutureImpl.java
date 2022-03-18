package com.example.java8;

//비동기 프로그래밍에 가깝다.
public class CompletableFutureImpl {

    static void excute() throws InterruptedException {
        //Runnable
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Sleep Thread Name: "+Thread.currentThread().getName());
        });
        thread.start();

        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello: "+ Thread.currentThread().getName()); //순서가 확실하지 않음

        Thread interruptedThread = new Thread(() -> {
            while (true) {
                System.out.println("Interrupted Thread Name: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);

                } catch (InterruptedException e) {
                    System.out.println("exit!");
                    return;
                }
            }
        });
        interruptedThread.start();

        Thread.sleep(3000L);
        System.out.println("Hello: "+ Thread.currentThread().getName()); //순서가 확실하지 않음
        interruptedThread.interrupt();

//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        Future<String> future = executorService.submit(()->"hello");
//
//        future.get();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread Name: "+Thread.currentThread().getName());
        }
    }
}
