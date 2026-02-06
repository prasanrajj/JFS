package threadsreality;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class newCachedThreadPool {

    public static void main(String[] args) {

    	ExecutorService executor = Executors.newCachedThreadPool();

    	for (int i = 1; i <= 10; i++) {
    	    executor.execute(new MyTask("Task-" + i));
    	}

    	executor.shutdown();

    }
}