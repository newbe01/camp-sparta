package week5.thread.priority;

public class Main {
    public static void main(String[] args) {

        Runnable task1 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.print("$");
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.print("#");
            }
        };

        Thread thread1 = new Thread(task1);
        thread1.setPriority(8);
        System.out.println(thread1.getPriority());

        Thread thread2 = new Thread(task2);
        thread2.setPriority(2);

        thread1.start();
        thread2.start();
    }
}
