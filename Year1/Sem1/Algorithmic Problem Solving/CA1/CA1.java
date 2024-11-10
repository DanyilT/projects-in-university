/*
Dany
CA-1 - Group 8
09/11/2023
*/

import java.util.Scanner;

public class question1 {
	public static void main(String[] args) {
		// Declare variables
		int dayNumber;
		String dayName;

		// Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

		// Get input from the user
		System.out.print("Enter a day of the week (1-7): ");
		dayNumber = scanner.nextInt();

		// Determine day name of the week based on the number
		switch (dayNumber) {
			case 1:
		        dayName = "Monday";
		        break;
		    case 2:
		        dayName = "Tuesday";
		        break;
		    case 3:
		        dayName = "Wednesday";
		        break;
		    case 4:
		        dayName = "Thursday";
		        break;
		    case 5:
		        dayName = "Friday";
		        break;
		    case 6:
		        dayName = "Saturday";
		        break;
		    case 7:
		        dayName = "Sunday";
		        break;
			default:
				dayName = "Invalid number";
		}

        // Output the day name
        System.out.println("Day Name: " + dayName);

        // Close the scanner
        scanner.close();
	}
}