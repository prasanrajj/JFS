package threadsreality;
 class Account {
    private int balance = 0;
    private boolean depositInProgress = true;
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " started deposit");
        // simulate waiting for cash counting / external process
        while (depositInProgress) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting...");
                wait();
                System.out.println("-----------after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposit completed. Balance = " + balance);
    }
    public synchronized void finishCounting() {
        System.out.println("Machine finished counting. Notifying...");
        depositInProgress = false;
        notify(); // or notifyAll()
    }
}

 class DepositTask implements Runnable {
    private Account account;
    public DepositTask(Account account) {
        this.account = account;
    }
    @Override
    public void run() {
        account.deposit(100);
    }
}
 
class MachineTask implements Runnable {
    private Account account;
    public MachineTask(Account account) {
        this.account = account;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(3000); // simulate counting time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.finishCounting();
    }
}

public class WaitAndNotifyWorking {
    public static void main(String[] args) {
        Account account = new Account();
        Thread t1 = new Thread(new DepositTask(account), "Employee-Thread");
        Thread t2 = new Thread(new MachineTask(account), "Machine-Thread");
        t1.start(); // deposit starts and waits
        t2.start(); // machine finishes and notifies
    }
}
