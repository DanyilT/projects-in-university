import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of rows (N)
        System.out.print("Enter the number of rows (N): ");
        int N = scanner.nextInt();

        // Use a for loop to print the pattern
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }

        // Close the scanner
        scanner.close();
    }
}
