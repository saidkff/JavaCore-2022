package Threads.lesson12_1;

public class Account {
    private int ID;
    private int balance;
    private static int generate = 1;

    public Account(int balance) {
        this.balance = balance;
        this.ID = generate++;
    }

    public void add(int value){
        this.balance+=value;
    }

    public boolean takeOff(int value){
        if (this.balance>=value){
            balance-=value;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", balance=" + balance +
                '}';
    }
}