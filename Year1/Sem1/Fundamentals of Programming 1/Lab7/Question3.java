import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter integer numbers with a sentinel of -1
        System.out.print("Enter integer numbers separated by spaces (enter -1 to stop): ");

        // Initialize variables
        int sumEven = 0;
        int number;

        // Read a line of space-separated numbers
        String inputLine = scanner.nextLine();
        Scanner lineScanner = new Scanner(inputLine);

        // Continue to read integer numbers until the user enters -1
        while (lineScanner.hasNextInt()) {
            number = lineScanner.nextInt();

            // Check if the number is even and not equal to -1
            if (number % 2 == 0 && number != -1) {
                sumEven += number;
            }

            // If -1 is encountered, break out of the loop
            if (number == -1) {
                break;
            }
        }

        // Print the sum of even numbers
        System.out.println("Sum of even numbers: " + sumEven);

        // Close the scanners
        scanner.close();
        lineScanner.close();
    }
}
