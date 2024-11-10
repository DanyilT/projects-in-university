import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        // Declare variables
        double radius;
        double height;
        double volume;
        
        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);
        
        // Get input from the user
        System.out.print("Enter the radius of the cylinder: ");
        radius = input.nextDouble();
        System.out.print("Enter the height of the cylinder: ");
        height = input.nextDouble();
        
        // Calculate the volume
        volume = 3.14 * radius * radius * height; // Using an approximation for π
        
        // Print the result
        System.out.println("The volume of the cylinder is: " + volume);
        
        // Close the Scanner
        input.close();
    }
}
