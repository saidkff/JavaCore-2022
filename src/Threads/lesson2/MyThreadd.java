package Threads.lesson2;

public class MyThreadd extends Thread {
    private volatile boolean flag;

    @Override
    public void run() {
        while (!flag) {
            System.out.println("Hello " + Thread.currentThread().getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stopMyThread(){
        this.flag = true;
    }
}
