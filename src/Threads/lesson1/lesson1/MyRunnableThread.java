package Threads.lesson1.lesson1;

public class MyRunnableThread implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<100; i++){
            System.out.println(Thread.currentThread().getName()+" "+ i);
        }
        System.out.println(Thread.currentThread().getName());
    }
}
