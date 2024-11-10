import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        // Declare variables
        int num;

        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter a number: ");
        num = scanner.nextInt();

        // Determine and print the type of number
        if (num > 0) {
            System.out.println("The number is positive.");
        } else if (num < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        // Close the scanner
        scanner.close();
    }
}
