import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Initialize variables
        int count = 0;
        int product = 1;

        // Use a while loop to prompt the user to enter 4 integer numbers
        while (count < 4) {
            System.out.print("Enter an integer number: ");
            int number = scanner.nextInt();

            // Update the product
            product *= number;

            // Increment the count
            count++;
        }

        // Print the product of the numbers entered
        System.out.println("Product of the numbers entered: " + product);

        // Close the scanner
        scanner.close();
    }
}
