import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        // Declare variables
        int sideA, sideB, sideC;

        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Get input from the user for the lengths of three sides
        System.out.print("Enter the length of side A: ");
        sideA = scanner.nextInt();
        System.out.print("Enter the length of side B: ");
        sideB = scanner.nextInt();
        System.out.print("Enter the length of side C: ");
        sideC = scanner.nextInt();

        // Check if the lengths form a triangle (Triangle Inequality Theorem)
        if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
            System.out.println("It is a TRIANGLE.");
        } else {
            System.out.println("It is NOT A TRIANGLE.");
        }

        // Close the scanner
        scanner.close();
    }
}
