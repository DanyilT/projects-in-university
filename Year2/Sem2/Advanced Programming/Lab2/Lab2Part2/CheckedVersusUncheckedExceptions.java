package Lab2Part2;

import java.io.File;
import java.io.IOException;

public class CheckedVersusUncheckedExceptions {
    public static void main(String[] args) {
        // Call capitalizeString method
        try {
            System.out.printf("Capitalized string: %s\n", capitalizeString("qwerty"));
        } catch (NullPointerException e) {
            System.err.println("Caught NullPointerException: " + e.getMessage());
        }

        // Call openFile method
        try {
            openFile("file.txt");
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        /*
        Explanation:
        The capitalizeString method does not require a try-catch block because
        NullPointerException is an unchecked exception (runtime exception).
        The openFile method requires a try-catch block because IOException is a
        checked exception, and the compiler forces us to handle it.
        */
    }

    // Method to capitalize a string, declared to throw NullPointerException
    public static String capitalizeString(String string) throws NullPointerException {
        if (string == null) {
            throw new NullPointerException("Input string is null");
        }
        return string.toUpperCase();
    }

    // Method to check if a file exists, declared to throw IOException
    public static void openFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IOException("File does not exist: " + fileName);
        }
        System.out.printf("File exists: %s\n", fileName);
    }
}
