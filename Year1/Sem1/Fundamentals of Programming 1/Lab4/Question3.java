import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        // Declare variable
        int grade;

        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the student's grade out of 100: ");
        grade = scanner.nextInt();

        // Check if the grade is 40% or higher
        if (grade >= 40) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        // Close the scanner
        scanner.close();
    }
}
