package week5.thread.multi;

public class Main {
    public static void main(String[] args) {
        Runnable task1 = () -> {
//            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 100; i++) {
                System.out.print("$");
            }
        };
        Runnable task2 = () -> {
//            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 100; i++) {
                System.out.print("*");
            }
        };

//        System.out.println(Thread.currentThread().getName());
        Thread thread1 = new Thread(task1);
        thread1.setName("thread1");
        thread1.start();

        Thread thread2 = new Thread(task2);
        thread2.setName("thread2");
        thread2.start();

    }
}
