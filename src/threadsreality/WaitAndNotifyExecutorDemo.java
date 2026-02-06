package threadsreality;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SharedResource {
    boolean ready = false;
}

class WaitingTask implements Runnable {

    private final SharedResource resource;

    WaitingTask(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        synchronized (resource) {
            while (!resource.ready) {
                try {
                    System.out.println("Waiting...");
                    resource.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Resumed work!");
        }
    }
}
class NotifierTask implements Runnable {

    private final SharedResource resource;

    NotifierTask(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        synchronized (resource) {
            resource.ready = true;
            resource.notify();
            System.out.println("Notified!");
        }
    }
}
public class WaitAndNotifyExecutorDemo {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new WaitingTask(resource));
        executor.execute(new NotifierTask(resource));

        executor.shutdown();
    }
}

