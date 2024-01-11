public class Question2 {
    public static void main(String[] args) {
        System.out.println("6 Rolls of an Eight-sided Dice:");
        for (int i = 1; i <= 6; i++) {
            int roll = (int) (Math.random() * 8) + 1;
            System.out.printf("Roll %d: %d\n", i, roll);
        }
    }
}
