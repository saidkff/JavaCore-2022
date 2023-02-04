package Threads.lesson10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        myExampleClass exampleClass = new myExampleClass();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                exampleClass.increment();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                exampleClass.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        exampleClass.getCounter();
    }
}

class myExampleClass{
    private int counter;
    private Lock lock = new ReentrantLock();

    public void increment(){
        lock.lock();                            // Берет монитор (Работает почти как блок synchronized)
        for (int i=0; i<10000; i++){
            counter++;
        }
        lock.unlock();                          // Опускает монитор
    }

    public void getCounter(){
        System.out.println(counter);
    }
}