package Threads.lesson14;

import java.util.Random;
import java.util.Scanner;

/**
 * Interrupt работает как монитор, вернет true если в потоке вызван метод Interrupt, либо же false если не вызван.
 * Он не останавливает поток, мы можем сами безопасно использовать эту функцию
 */
public class InterruptDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(), "MyThread");
        thread.start();

        new Scanner(System.in).nextLine();
        thread.interrupt();
    }
}

class MyRunnable implements Runnable {
    private Random random = new Random();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started!");
        for (int i = 0; i < 1_000_000_000; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread was interrupted! ");
                break;
            }
            Math.cos(random.nextDouble(100));
        }
    }
}

