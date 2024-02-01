import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        // Declare variables
        int value1;
        int value2;
        int value3;
        int value4;
        double average;
        
        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);
        
        // Get input from the user
        System.out.print("Enter the first integer value: ");
        value1 = input.nextInt();
        System.out.print("Enter the second integer value: ");
        value2 = input.nextInt();
        System.out.print("Enter the third integer value: ");
        value3 = input.nextInt();
        System.out.print("Enter the fourth integer value: ");
        value4 = input.nextInt();
        
        // Calculate the average
        average = (value1 + value2 + value3 + value4) / 4.0; // Ensure at least one operand is a double
        
        // Print the result
        System.out.println("The average of the four integer values is: " + average);
        
        // Close the Scanner
        input.close();
    }
}
