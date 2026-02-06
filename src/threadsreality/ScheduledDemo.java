package threadsreality;

import java.util.concurrent.*;

public class ScheduledDemo {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println(
                "Running at " + System.currentTimeMillis() +
                " on " + Thread.currentThread().getName()
            );
        }, 0, 3, TimeUnit.SECONDS);
    }
}

