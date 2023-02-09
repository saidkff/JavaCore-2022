package Threads.lesson12_1;

public class AccountThread extends Thread {
    private final Account account1;
    private final Account account2;

    public AccountThread(Account account1, Account account2) {
        this.account1 = account1;
        this.account2 = account2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            synchronized (account1) {           /** Здесь появляется DeadLock, чтобы решить проблему мы можем использовать ReentrantLock**/
                synchronized (account2) {           /** Использование ReentrantLock вы можете увидеть в папке lesson12_2 **/
                    if (account1.takeOff(18)) {
                        account2.add(18);
                    }
                }
            }
        }
    }
}
