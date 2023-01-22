package Threads.lesson1.lesson1;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnableThread());
        thread.start();
        Thread.sleep(800);
        Thread thread1 = new Thread(new MyRunnableThread());
        thread1.start();

        System.out.println(Thread.currentThread().getName());
    }
}
