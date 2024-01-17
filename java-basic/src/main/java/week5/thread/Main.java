package week5.thread;

public class Main {
    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();

        TestRunnable run = new TestRunnable();
        Thread thread1 = new Thread(run);
        thread1.start();

        Runnable task = () -> {
            int sum = 0;
            for (int i = 0; i < 50; i++) {
                sum += i;
                System.out.println(sum);
            }
            System.out.println(Thread.currentThread().getName() + "sum : " + sum);
        };

        Thread thread3 = new Thread(task);
        thread3.setName("thread3");

        Thread thread4 = new Thread(task);
        thread4.setName("thread4");

        thread3.start();
        thread4.start();
    }
}
