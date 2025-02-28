package Lab5Part3a;

public class ThreadUsingExtends extends Thread {
    private static final String[] LETTERS = {"A", "B", "C", "D"};
    private static int threadCount = 0;
    private static final Object lock = new Object();

    public ThreadUsingExtends(String baseName) {
        super(baseName + " " + (++threadCount));
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (String letter : LETTERS) {
                System.out.println(getName() + " " + letter);
            }
        }
    }
}
