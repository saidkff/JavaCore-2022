package Threads.PracticeThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultiThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer consumer = new ProducerConsumer();
        Thread thread1 = new Thread(() -> {
            try {
                consumer.Producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                consumer.Consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class ProducerConsumer {
    private List<Integer> list = new ArrayList<>();
    private final Random random = new Random();

    public void Producer() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (list.size() >= 10) {
                    this.wait();
                }
                System.out.println("Added element: ");
                list.add(random.nextInt(100));
                this.notify();
            }
        }
    }

    public void Consumer() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (list.size() == 0) {
                    this.wait();
                }
                System.out.println("Deleted element: " + list.get(list.size() - 1));
                list.remove(list.size() - 1);
                System.out.println("Size of list is: " + list.size());
                notify();
            }
            Thread.sleep(10);
        }
    }
}
