import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter circle radius: ");
        double radius = scanner.nextDouble();
        scanner.close();

        System.out.printf("Circumference = %.2f%n", calculateCircumference(radius));
        System.out.printf("Area = %.2f%n", calculateArea(radius));
    }

    public static double calculateCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
}
