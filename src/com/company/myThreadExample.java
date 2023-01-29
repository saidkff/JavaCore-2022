package com.company;

import java.util.concurrent.Executors;

public class myThreadExample extends Thread{
    private static int A;
    private static int B;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                startIncrements();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                startIncrements();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Time is: " + (endTime-startTime));

        getSizes();

    }

    public static synchronized void incrementA(){
        A++;
    }

    public static synchronized void incrementB(){
        B++;
    }

    public static void startIncrements(){
        for (int i=0; i<1000; i++){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            incrementA();
            incrementB();
        }
    }

    public static void getSizes(){
        System.out.println("Size of A is: " + A);
        System.out.println("Size of B is: " + B);
    }
}
