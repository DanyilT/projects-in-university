import java.util.Random;

public class Question4 {
    public static void main(String[] args) {
        // Initialize variables
        Random rand = new Random();
        int[] numbers = new int[100];

        // Initialising the array with random values between 1 – 20
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1, 21);
        }

        // Printing all values in the array
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
