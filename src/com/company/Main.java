package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1 start!");
            synchronized (lock1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {

                }
            }
            System.out.println("Thread1 end!");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2 start!");
            SolveDeadLock(lock2, lock1);
            System.out.println("Thread2 end!");
            lock2.unlock();
            lock1.unlock();
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public static void SolveDeadLock(Lock lock1, Lock lock2) {
        boolean flag1 = false;
        boolean flag2 = false;
        try {
            flag1 = lock1.tryLock();
            flag2 = lock2.tryLock();
        } finally {
            while (true) {
                if (flag1 && flag2) {
                    return;
                }
                if (flag1) {
                    lock1.unlock();
                }
                if (flag2) {
                    lock2.unlock();
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
