package Lab5Part1;

public class ThreadUsingExtends extends Thread {
    private static final String[] LETTERS = {"A", "B", "C", "D"};
    private static int threadCount = 0;

    public ThreadUsingExtends(String baseName) {
        super(baseName + " " + (++threadCount));
    }

    @Override
    public void run() {
        for (String letter : LETTERS) {
            System.out.println(getName() + " " + letter);
        }
    }
}
