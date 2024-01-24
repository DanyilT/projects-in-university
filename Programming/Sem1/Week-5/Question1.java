import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        // Declare variables
        int number;
        String[] ones, tens;

        // Initialize arrays for ones and tens places
        ones = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        tens = new String[]{"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter an integer between 1 and 100: ");
        number = scanner.nextInt();

        // Check if the number is within the valid range
        if (number < 1 || number > 100) {
            System.out.println("Invalid number!");
        } else if (number < 20) {
            System.out.println(ones[number - 1]);  // Arrays start from 0
        } else if (number < 100) {
            // Split the number into tens and ones places
            int tensPlace = number / 10;
            int onesPlace = number % 10;

            // Output the number in words
            System.out.println(tens[tensPlace - 2] + " " + ones[onesPlace - 1]);  // Arrays start from 0
        } else {
            System.out.println("one hundred");
        }

        // Close the scanner
        scanner.close();
    }
}
