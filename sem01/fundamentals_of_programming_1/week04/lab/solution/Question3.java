import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        // Declare variables
        int grade;
        String alphabeticGrade;

        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the student's grade (0-100): ");
        grade = scanner.nextInt();

        // Determine the alphabetic grade
        if (grade >= 1 && grade <= 100) {
            System.out.println("Number in range!");
            if (grade >= 80) {
                alphabeticGrade = "A";
            } else if (grade >= 70) {
                alphabeticGrade = "B+";
            } else if (grade >= 60) {
                alphabeticGrade = "B";
            } else if (grade >= 55) {
                alphabeticGrade = "B-";
            } else if (grade >= 50) {
                alphabeticGrade = "C+";
            } else if (grade >= 40) {
                alphabeticGrade = "C";
            } else if (grade >= 35) {
                alphabeticGrade = "D";
            } else {
                alphabeticGrade = "F";
            }
        } else {
            alphabeticGrade = "Not in range";
        }

        // Print the alphabetic grade
        System.out.println("Alphabetic Grade: " + alphabeticGrade);

        // Close the scanner
        scanner.close();
    }
}
