package Threads.lesson13;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Runnable не сможет вернуть занчение из потока, так как модификатор доступа void
 * Чтобы вощвращать значение мы можем использовать Callable
 *
 */
public class CallableAndFutureDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new MyRunnable());
        Future<Integer> future = service.submit(new MyCallable());
    }
}

class MyCallable implements Callable<Integer> {

    private final Random random = new Random();

    @Override
    public Integer call() {
        System.out.println(Thread.currentThread().getName() + " start!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " end! ");
        return random.nextInt();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end!");
    }
}