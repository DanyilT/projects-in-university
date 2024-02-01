import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        // Declare variables
        int a, b, c;
        String triangleType;

        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Get input from the user for the lengths of three sides
        System.out.print("Enter the length of side a: ");
        a = scanner.nextInt();
        System.out.print("Enter the length of side b: ");
        b = scanner.nextInt();
        System.out.print("Enter the length of side c: ");
        c = scanner.nextInt();

        // Check if it's a triangle based on the triangle inequality theorem
        if (a + b > c && a + c > b && b + c > a) {
            // Check if it's an equilateral triangle
            if (a == b && b == c) {
                triangleType = "Equilateral";
            }
            // Check if it's an isosceles triangle
            else if (a == b || a == c || b == c) {
                triangleType = "Isosceles";
            }
            // If it's not equilateral or isosceles, it's scalene
            else {
                triangleType = "Scalene";
            }

            // Check for right-angled triangle using Pythagorean Theorem
            if (a * a + b * b == c * c || b * b + c * c == a * a || a * a + c * c == b * b) {
                System.out.println("Triangle, " + triangleType + ", right-angled");
            } else {
                System.out.println("Triangle, " + triangleType + ", not right-angled");
            }
        } else {
            System.out.println("Not a triangle");
        }

        // Close the scanner
        scanner.close();
    }
}
