package Threads.lesson2;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        MyThreadd thread = new MyThreadd();
        thread.start();
        Thread.sleep(500);

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        thread.stopMyThread();

        System.out.println(Thread.currentThread().getName());
    }
}
