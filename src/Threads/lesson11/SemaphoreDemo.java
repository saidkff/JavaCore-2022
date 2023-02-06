package Threads.lesson11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        Connection connection = Connection.getConnection();     //Singleton

        ExecutorService service = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 200; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.doWork();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        service.shutdown();
        System.out.println("All tasks have been submitted!");
        service.awaitTermination(3, TimeUnit.DAYS);
    }
}


//Singleton
class Connection {
    private static Connection connection = new Connection();
    private Semaphore semaphore = new Semaphore(10);
    private int counter;

    private Connection() {

    }

    public void doWork() throws InterruptedException {
        semaphore.acquire();                                    //// Semaphore не допустит больше 10 потоков
        try {
            work();
        } finally {
            semaphore.release();
        }
    }

    public void work() throws InterruptedException {
        synchronized (this) {
            System.out.println(counter++);
        }
        Thread.sleep(3000);
    }

    public static Connection getConnection() {
        return connection;
    }
}
