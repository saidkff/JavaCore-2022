package Threads.lesson7;

import java.util.Scanner;

public class WaitAndNotifyDemo {
    public static void main(String[] args) {

        WaitAndNotifyDemo demo = new WaitAndNotifyDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    demo.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    demo.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
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
    }

    public void producer() throws InterruptedException {
        synchronized (this){
            System.out.println("The Producer has started!");
            wait();    // Освобождает монитор обекта this до тех пор когда вызовится notify и заончится выполнения тело его метода
            System.out.println("The Producer has finished!");
        }
    }

    public void consumer() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        synchronized (this){
            System.out.println("The Consumer has started!");
            scanner.nextLine();
            Thread.sleep(2000);
            notify();
            System.out.println("The Consumer has finished!");
        }
    }
}
