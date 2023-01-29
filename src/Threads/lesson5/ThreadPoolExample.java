package Threads.lesson5;

public class ThreadPoolExample extends Thread{
    private int ID;

    public ThreadPoolExample(int ID) {
        this.ID = ID;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Work "+ ID + " was completed!");
    }
}
