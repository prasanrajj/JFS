package threadsreality;

public class MyTask implements Runnable {

    private final String taskName;

    MyTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(
            "Task " + taskName + " is running on " + threadName
        );

        try {
            Thread.sleep(2000); // simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(
            "Task " + taskName + " finished on " + threadName
        );
    }
    public static void main(String[] args) {
		MyTask task1 = new MyTask("prasann1a work");
		Thread t1 = new Thread(task1);
		
		t1.start();
	}
}

