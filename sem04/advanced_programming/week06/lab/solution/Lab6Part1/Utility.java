package Lab6Part1;

/**
 * Utility class for mathematical calculations.
 */
public class Utility {
    public static final double PI = 3.14159;

    /**
     * Calculates the circumference of a circle given its radius.
     *
     * @param radius the radius of the circle
     * @return the circumference of the circle
     */
    public static double calculateCircumference(double radius) {
        return 2 * PI * radius;
    }
}
