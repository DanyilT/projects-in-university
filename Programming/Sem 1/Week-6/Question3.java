import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Constants
        double rate = 0.125;      // Annual interest rate (12.5%)
        int years = 6;            // Number of years

        // Prompt the user to enter invest capital amount
        System.out.print("Enter capital to invest: ");
        double principal = scanner.nextDouble();

        // Print table headers
        System.out.printf("%-10s %-20s %-20s %-20s\n", "Year", "Interest", "Cumulative Interest", "New Capital");

        // Calculate and print compound interest for each year
        double cumulativeInterest = 0.0;
        for (int year = 1; year <= years; year++) {
            double interest = principal * rate;
            cumulativeInterest += interest;
            principal += interest; // Update the principal for the next year

            // Print results for the current year
            System.out.printf("%-10d $%-19.2f $%-19.2f $%-19.2f\n", year, interest, cumulativeInterest, principal);
        }

        // Close the scanner
        scanner.close();
    }
}
