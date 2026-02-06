package threadsreality;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newSingleThreadExecutor {

    public static void main(String[] args) {

    	ExecutorService executor = Executors.newSingleThreadExecutor();

    	executor.execute(new MyTask("A"));
    	executor.execute(new MyTask("B"));
    	executor.execute(new MyTask("C"));

    	executor.shutdown();
    }
}

