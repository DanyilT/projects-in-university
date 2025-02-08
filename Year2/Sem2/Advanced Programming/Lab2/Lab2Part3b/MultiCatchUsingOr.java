package Lab2Part3b;

public class MultiCatchUsingOr {
    public static void main(String[] args) {
        try {
            // Uncomment one of the following lines to test different exceptions

            // NullPointerException
            String string = null;
            string.length(); // This will throw NullPointerException

            // StringIndexOutOfBoundsException
            // String string = "example";
            // char c = string.charAt(10); // This will throw StringIndexOutOfBoundsException

        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            System.err.println("Caught an exception");
            e.printStackTrace();
        }
    }
}
