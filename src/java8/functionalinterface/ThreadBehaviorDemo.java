package java8.functionalinterface;

class MyTask implements Runnable {
	public void run() {
		System.out.println("Thread - runnable class is running");
	}
}

public class ThreadBehaviorDemo {
	public static void main(String[] args) {

		// 1️ Runnable implementation class
		Runnable r1 = new MyTask();
		Thread t1 = new Thread(r1);
		t1.start();

		// 2️ Anonymous Runnable class
		Runnable r2 = new Runnable() {
			public void run() {
				System.out.println("Thread - anonymous runnable class is running");
			}
		};
		Thread t2 = new Thread(r2);
		t2.start();

		// 3️⃣ Lambda Runnable (functional interface)
Thread t3 = new Thread(() -> System.out.println("Thread - runnable lambda expression is running"));
		t3.start();
	}
}
