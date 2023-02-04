package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i=0; i<3; i++){
            executorService.submit(new myClass(countDownLatch));
        }
        executorService.shutdown();

        countDownLatch.await();

        System.out.println("Letch have been opened, main thread is proceeding");
    }
}

class myClass extends Thread{
    private CountDownLatch countDownLatch;

    public myClass(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        countDownLatch.countDown();
    }
}