package Lab5Part2;

public class ThreadUsingRunnable implements Runnable {
    private static final int[] NUMBERS = {1, 2, 3, 4};
    private static int threadCount = 0;
    private final String baseName;

    public ThreadUsingRunnable(String baseName) {
        this.baseName = baseName;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(baseName + " " + (++threadCount));
        for (int number : NUMBERS) {
            System.out.println(Thread.currentThread().getName() + " " + number);
        }
    }
}
