package Lab5Part3a;

public class TestThread {
    public static void main(String[] args) {
        String baseName = "Tymchuk";

        // Create and start at least five instances of ThreadUsingExtends
        for (int i = 0; i < 5; i++) {
            ThreadUsingExtends thread = new ThreadUsingExtends(baseName);
            thread.start();
        }
    }
}
