public class CarSales{
    public static void printCarSales(int[][] array, String[] months, String[] manufacturers){
        // Print header
        System.out.printf("%-10s", "Month");
        for (String month : months) {
            System.out.printf("%-10s", month);
        }
        System.out.println();
        
        // Print car sales data
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%-10s", manufacturers[i]);
            for (int sales : array[i]) {
                System.out.printf("%-10d", sales);
            }
            System.out.println();
        }
    }

    public static int[] calculateTotals(int[][] array){
        int[] totals = new int[array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                totals[j] += array[i][j];
            }
        }
        return totals;
    }

    public static void printTotals(int[] array){
	System.out.printf("===========================================================================================================================\n");
        System.out.printf("%-10s", "Totals");
        for (int total : array) {
            System.out.printf("%-10d", total);
        }
        System.out.println();
    }

    public static void main(String[] args){
        // Assuming a sample data structure for demonstration
        int[][] salesData = {
            {5, 10, 8, 7, 9, 7, 11, 5, 6, 3, 2, 2}, // Ford
            {2, 6, 7, 4, 6, 4, 7, 4, 3, 4, 3, 1}, // Peugeot
            {2, 4, 5, 4, 5, 3, 4, 4, 2, 3, 3, 2}, // Mazda
            {4, 5, 8, 10, 8, 7, 6, 5, 5, 4, 3, 2}, // Nissan
            {1, 2, 4, 5, 4, 2, 3, 2, 0, 0, 0, 0}, // Renault
        };

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] manufacturers = {"Ford", "Peugeot", "Mazda", "Nissan", "Renault"};

        // Calculate the column totals
        int[] totals = calculateTotals(salesData);
        
        // Print the table data
        printCarSales(salesData, months, manufacturers);
        
        // Print the column totals
        printTotals(totals);
    }
}
