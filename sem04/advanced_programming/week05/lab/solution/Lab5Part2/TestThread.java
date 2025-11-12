package Lab5Part2;

public class TestThread {
    public static void main(String[] args) {
        String baseName = "Tymchuk";

        // Create and start at least five instances of ThreadUsingRunnable
        for (int i = 0; i < 5; i++) {
            ThreadUsingRunnable runnable = new ThreadUsingRunnable(baseName);
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
