package Threads.lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lesson4Example {
    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                startAddToList();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                startAddToList();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time" + (endTime-startTime)*10);
        getSize();
    }

    public static void startAddToList(){
        for (int i=0; i<1000; i++){
            addToList1();
            addToList2();
        }
    }

    public static void addToList1(){
        list1.add(random.nextInt(100));
    }

    public static void addToList2(){
        list2.add(random.nextInt(100));
    }

    public static void getSize(){
        System.out.println("size of list1 is: " + list1.size());
        System.out.println("size of list2 is: " + list2.size());
    }
}
