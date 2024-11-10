import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        // Declare variables
        double hours_worked;
        double hourly_rate;
        double gross_pay;
        
        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);
        
        // Get input from the user
        System.out.print("Enter the number of hours worked: ");
        hours_worked = input.nextDouble();
        System.out.print("Enter the hourly rate of pay: ");
        hourly_rate = input.nextDouble();
        
        // Calculate the gross pay
        gross_pay = hours_worked * hourly_rate;
        
        // Print the result
        System.out.println("Hours worked: " + hours_worked);
        System.out.println("Hourly rate: " + hourly_rate);
        System.out.println("The employee's gross weekly pay is: " + gross_pay);
        
        // Close the Scanner
        input.close();
    }
}
