package Threads.lesson9;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);

        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i=0; i<4; i++){                                                   // Если зададим 3 заданий, тогда программа не завершится!
            service.submit(new CountDownLetchClass(countDownLatch));
        }
        service.shutdown();

        countDownLatch.await();                                                    // Прграмма дальше не идет, пока не вызовится команда shutdown 4 раза!

        System.out.println("Letch have been opened, main thread is proceeding");
    }
}

class CountDownLetchClass implements Runnable{
    private CountDownLatch countDownLatch;

    public CountDownLetchClass(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName());
        countDownLatch.countDown();
    }
}