package Threads.lesson8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerAndConsumerWithWaitAndNotify {

    public static void main(String[] args) throws InterruptedException {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerAndConsumer.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerAndConsumer.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class ProducerAndConsumer {
    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;

    public void producer() throws InterruptedException {
        Random random = new Random();
        while (true){
            synchronized (this){
                if (queue.size() == 10){
                    wait();
                }
                queue.add(random.nextInt(100));
                notify();
            }
        }
    }

    public void consumer() throws InterruptedException {
        while (true){
            synchronized (this){
                if (queue.size() == 0){
                    wait();
                }
                Integer poll = queue.poll();
                System.out.println(poll);
                System.out.println("Size is: " + queue.size());
                notify();
            }
            Thread.sleep(1);
        }
    }
}
