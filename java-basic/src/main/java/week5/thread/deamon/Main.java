package week5.thread.deamon;

public class Main {
    public static void main(String[] args) {
        Runnable demon = () -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("demon");
            }
        };

        Thread thread = new Thread(demon);
        thread.setDaemon(true);

        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("task");
        }
    }

}
