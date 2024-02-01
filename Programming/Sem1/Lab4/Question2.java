public class Question2 {
    public static void main(String[] args) {
        // Declare variables
        int x, y;

        // Assign values to x and y
        x = 4;
        y = 10;

        // a) X is an even number
        if (x % 2 == 0) {
            System.out.println("x is an even number is true");
        } else {
            System.out.println("x is an even number is false");
        }

        // b) X multiplied by 5 is less than 7 squared
        if (x * 5 < 7 * 7) {
            System.out.println("x multiplied by 5 is less than 7 squared is true");
        } else {
            System.out.println("x multiplied by 5 is less than 7 squared is false");
        }

        // c) Y minus X is positive
        if (y - x > 0) {
            System.out.println("y minus x is positive is true");
        } else {
            System.out.println("y minus x is positive is false");
        }

        // d) Y cubed is less than 100
        if (y * y * y < 100) {
            System.out.println("y cubed is less than 100 is true");
        } else {
            System.out.println("y cubed is less than 100 is false");
        }
    }
}
