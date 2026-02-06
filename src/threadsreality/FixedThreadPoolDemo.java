package threadsreality;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new MyTask("T1"));
        executor.execute(new MyTask("T2"));
        executor.execute(new MyTask("T3"));
        executor.execute(new MyTask("T4"));

        executor.shutdown();
    }
}

