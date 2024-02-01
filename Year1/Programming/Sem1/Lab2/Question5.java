public class Question5 {
    public static double f(double x) {
        return x * x + 3 * x - 5;
    }

    public static void main(String[] args) {
        // Declare variables
        int x = 4;
        double result;

        // Evaluate f(x) where x = 4 and x = 6
        result = f(x);

        // Print the results and the expressions
        System.out.println("f(x) = x * x + 3 * x - 5");
        System.out.println("f(4) = " + result);
    }
}
