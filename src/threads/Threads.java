package threads;

class SharedLock {
}

class WaitingThread extends Thread {

	private Threads lock;

	public WaitingThread(Threads lock, String name) {
		super(name);
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			try {
				Thread.sleep(2000);
				System.out.println(getName() + " waiting...");
				lock.wait();
				System.out.println(getName() + " resumed!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class NotifyingThread extends Thread {

	private Threads lock;

	public NotifyingThread(Threads lock, String name) {
		super(name);
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + " notifying...");
			lock.notifyAll();
		}
	}
}

public class Threads {

	public static void main(String[] args) throws Exception {

		Threads lock = new Threads();

		Thread t1 = new WaitingThread(lock, "T1");
		Thread t2 = new WaitingThread(lock, "T2");
		Thread t3 = new NotifyingThread(lock, "T3");

		t1.start();
		t2.start();

		Thread.sleep(2000); // just to ensure T1 & T2 wait

		t3.start();
		System.out.println("main done");
	}
}
