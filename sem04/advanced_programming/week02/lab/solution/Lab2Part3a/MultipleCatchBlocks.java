package Lab2Part3a;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        try {
            // Uncomment one of the following lines to test different exceptions

            // ArrayIndexOutOfBoundsException
            int[] array = new int[4];
            int value = array[4]; // This will throw ArrayIndexOutOfBoundsException

            // ArithmeticException
            // int result = 10 / 0; // This will throw ArithmeticException

            // Exception (generic)
            // throw new Exception("Generic exception"); // This will throw a generic Exception

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("You are trying to access beyond the array bounds");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.err.println("You are trying to divide by zero");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("A generic exception occurred");
            e.printStackTrace();
        }
    }
}
