package threads;

class MyTask extends Thread {

    String name;

    MyTask(String name) {
        this.name = name;
    }

    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(name + " running " + i);
        }
    }
}

public class ThreadPriority {
    public static void main(String[] args) {

        MyTask low = new MyTask("LOW Priority Thread");
        MyTask high = new MyTask("HIGH Priority Thread");

        low.setPriority(Thread.MIN_PRIORITY);   // 1
        high.setPriority(Thread.MAX_PRIORITY);  // 10

        low.start();
        high.start();
    }
}
