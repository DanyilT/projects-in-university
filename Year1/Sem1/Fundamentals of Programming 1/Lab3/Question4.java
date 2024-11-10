import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        // Declare variables
        int monthNumber;
        String monthName;

        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter a month number (1-12): ");
        monthNumber = scanner.nextInt();

        // Determine month name based on the month number
        switch (monthNumber) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                monthName = "Invalid month number";
        }

        // Output the month name
        System.out.println("Month Name: " + monthName);

        // Close the scanner
        scanner.close();
    }
}
