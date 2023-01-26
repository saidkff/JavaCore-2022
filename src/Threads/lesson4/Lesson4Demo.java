package Threads.lesson4;

public class Lesson4Demo {
    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                startTask1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                startTask2();
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

    public static void startTask1(){
        synchronized (object1) {
            System.out.println("Захватил монитор A");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Опустил! A");
        }
    }

    public static void startTask2(){
        synchronized (object2) {
            System.out.println("Захватил монитор B");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Опустил! B");
        }
    }
}
