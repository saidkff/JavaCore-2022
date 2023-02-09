package Threads.lesson12;

import java.util.Random;

public class DeadLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable();
        Thread thread1 = new Thread(new java.lang.Runnable() {
            @Override
            public void run() {
                runnable.MethodForThread1();
            }
        });

        Thread thread2 = new Thread(new java.lang.Runnable() {
            @Override
            public void run() {
                runnable.MethodForThread2();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        runnable.finished();
    }
}

class Runnable{
    private final Account account1 = new Account();
    private final Account account2 = new Account();
    private final Random random = new Random();

    public void MethodForThread1(){
        int value;
        for (int i=0; i<1000; i++){
            value = random.nextInt(100);
            synchronized (account1){                        /** Первый поток захватил монитор account1 и ждет освобождения монитора account2
                                                                        А второй поток наоборот. Случается DeadLock. Чтобы решить можно использовать ReentrantLock, или же упорядочить захват монитора!  #08.02.2023
                                                                **/
                synchronized (account2){
                    account1.sent(value);
                    account2.deposit(value);
                }
            }
        }
    }

    public void MethodForThread2(){
        int value;
        for (int i=0; i<1000; i++){
            value = random.nextInt(100);
            synchronized (account2){
                synchronized (account1){
                    account2.sent(value);
                    account1.deposit(value);
                }
            }
        }
    }

    public void finished(){
        System.out.println("All tasks have been finished!");
        System.out.println("Balance account1: " + account1.getBalance());
        System.out.println("Balance account2: " + account2.getBalance());
        System.out.println("Balance: " + (account1.getBalance()+account2.getBalance()));
    }
}

class Account{
    private int balance = 10000;

    public void deposit(int value){
        balance+=value;
    }

    public void sent(int value){
        balance-=value;
    }

    public int getBalance() {
        return balance;
    }
}