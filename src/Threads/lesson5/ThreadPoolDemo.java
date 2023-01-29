package Threads.lesson5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i=0; i<5; i++){
            service.submit(new ThreadPoolExample(i));
        }
        service.shutdown();

        System.out.println("All tasks submitted!");
    }
}
