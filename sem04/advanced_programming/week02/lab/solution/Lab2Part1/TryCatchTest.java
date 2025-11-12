package Lab2Part1;

public class TryCatchTest {
    private static final String surname = "Tymchuk";

    public static void main(String[] args) {
        // First try-catch-finally block
        try {
            char c = surname.charAt(100); // Deliberate error: index out of bounds
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace(); // Print stack trace
        } finally {
            System.out.printf("Finally block executed. Surname: %s\n", surname);
        }

        // Second try-finally block
        try {
            System.out.println("Test try without catch");
        } finally {
            System.out.println("There's no catch");
        }
    }
}
