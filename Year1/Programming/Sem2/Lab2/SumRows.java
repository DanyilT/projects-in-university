import java.util.Random;

public class SumRows {
    
    public static void main(String[] args) {
	// 10 rows and 12 columns
        int rows = 10;
        int columns = 12;
        int[][] array = new int[rows][columns];

        initializeArray(array);
	// Print all
        printRowTotals(array);
    }

    public static void initializeArray(int[][] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
		// Random number between 1 and 20
                array[i][j] = rand.nextInt(20) + 1;
            }
        }
    }

    public static int calculateRowTotals(int[] row) {
        int sum = 0;
	// Add the number to the sum of the row
        for (int num : row) {
            sum += num;
        }
        return sum;
    }

    public static void printRowTotals(int[][] array) {
        System.out.println("Rows:");
        for (int[] row : array) {
            for (int num : row) {
                System.out.printf("%2d ", num);
            }
            int sum = calculateRowTotals(row);
            System.out.println(" = " + sum);
        }
    }
}
