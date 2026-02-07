package executors;

import java.util.concurrent.*;

public class ExecutorServiceBigPicture {

	public static void main(String[] args) {
		
		// Runnable Interface
		Runnable task = () -> System.out.println("Task running on thread : " 
		+ Thread.currentThread().getName());

		// ExecutorService (interface)
		// Executors (factory / utility class)

		// SingleThreadExecutor
		ExecutorService single = Executors.newSingleThreadExecutor();

		// FixedThreadPool
		ExecutorService fixed = Executors.newFixedThreadPool(4);

		// CachedThreadPool
		ExecutorService cached = Executors.newCachedThreadPool();

		// ScheduledThreadPool
		ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(2);

		// ForkJoinPool
		ExecutorService forkJoin = ForkJoinPool.commonPool();

		single.execute(task);
		fixed.execute(task);
		cached.execute(task);
		forkJoin.execute(task);
		scheduled.schedule(task, 1, TimeUnit.SECONDS);

		

		single.shutdown();
		fixed.shutdown();
		cached.shutdown();
		scheduled.shutdown();
		forkJoin.shutdown();
	}
}
