package week5.thread.stat.join;

public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread = new Thread(task, "thread");
        thread.start();

        long start = System.currentTimeMillis();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("time ::"  + (System.currentTimeMillis() - start));

    }
}
