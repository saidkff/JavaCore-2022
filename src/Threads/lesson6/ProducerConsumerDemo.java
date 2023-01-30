package Threads.lesson6;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerDemo {
    private static ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer();
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void producer(){
        Random random = new Random();
        while(true){
            try {
                arrayBlockingQueue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void consumer(){
        while(true){
            Integer take = null;
            try {
                take = arrayBlockingQueue.take();
                System.out.println("Element is: " + take);
                System.out.println("Size is:" + arrayBlockingQueue.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
