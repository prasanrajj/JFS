package executors;
import java.util.concurrent.*;

public class RunnableVsCallableDemo {

	// Runnable task (no return)
	static class MyRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() 
					+ " executing Runnable task");
		}
	}

	// Callable task (returns value)
	static class MyCallable implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			System.out.println(Thread.currentThread().getName() 
					+ " executing Callable task");
			Thread.sleep(2000); // simulate work
			return 42;
		}
	}

	public static void main(String[] args) throws Exception {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		// Runnable execution (fire and forget)
		executor.execute(new MyRunnable());

		// Callable execution (expects result)
		Future<Integer> future = executor.submit(new MyCallable());

		System.out.println("Main thread doing other work...");

		// This blocks ONLY the main thread
		Integer result = future.get();

		System.out.println("Result from Callable = " + result);
		executor.shutdown();
//        executor.execute(new MyRunnable()); 
//        once closed it gives RejectedExecutionException
		System.out.println();
	}
}
