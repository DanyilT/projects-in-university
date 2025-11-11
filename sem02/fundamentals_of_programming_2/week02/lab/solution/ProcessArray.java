import java.util.Random;

public class ProcessArray {
    // Main method
    public static void main(String[] args) {
        // Declare an empty array
        int[] myData;

        // Create the array with random numbers from 1 to 100
        myData = makeRandomArray(200, 100, 1);

        // Print the array
        printArray(myData);

        // Sum the array and print the result
        System.out.printf("Array sum %d\n", sumArray(myData));

        // Average the array and print the result
        System.out.printf("Array average %f\n", averageArray(myData));

        // Find frequency of 10 and print the result
        System.out.printf("Frequency of 10 is %d\n", frequency(myData, 10));

        // Zero the array
        zeroArray(myData);

        // Print the array again to show it has been zeroed
        printArray(myData);
    }
    
    // Creates and returns an array of given size with random values between lower and upper bounds
    public static int[] makeRandomArray(int size, int upper, int lower) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(upper - lower + 1) + lower;
        }
        return array;
    }
    
    // Prints the array elements separated by space
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    // Returns the sum of elements in the array
    public static int sumArray(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
    
    // Calculates and returns the average value of the array elements
    public static double averageArray(int[] array) {
        return (double) sumArray(array) / array.length;
    }
    
    // Counts and returns the frequency of a given value in the array
    public static int frequency(int[] array, int value) {
        int count = 0;
        for (int i : array) {
            if (i == value) {
                count++;
            }
        }
        return count;
    }
    
    // Sets all the elements of the array to zero
    public static void zeroArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }
}
