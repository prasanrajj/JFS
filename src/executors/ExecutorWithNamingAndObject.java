package executors;

import java.util.concurrent.*;

public class ExecutorWithNamingAndObject {

    static class WorkerTask implements Runnable {
        private final String data;

        WorkerTask(String data) {
            this.data = data;
        }

        @Override
        public void run() {
            System.out.println(
                Thread.currentThread().getName() +
                " processing data : " + data
            );
        }
    }

    public static void main(String[] args) {

        ThreadFactory namingFactory = r -> {
            Thread t = new Thread(r);
            t.setName("MyWorker-" + t.getId());
            return t;
        };

        ExecutorService executor =
                Executors.newFixedThreadPool(2, namingFactory);

        executor.execute(new WorkerTask("User-1"));
        executor.execute(new WorkerTask("User-2"));
        executor.execute(new WorkerTask("User-3"));

        executor.shutdown();
    }
}
