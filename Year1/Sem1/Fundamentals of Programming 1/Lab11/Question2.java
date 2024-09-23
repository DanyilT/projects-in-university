public class Question2 {
    public static void main(String[] args) {
        printAscii();
    }

    public static void printAscii() {
        for (int i = 32; i < 127; i++) {
            System.out.printf("%c ", i);
            if ((i - 31) % 10 == 0) {
                System.out.println();
            }
        }
    }
}
