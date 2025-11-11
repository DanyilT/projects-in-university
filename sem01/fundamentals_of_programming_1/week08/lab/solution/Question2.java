public class Question2 {
    public static void main(String[] args) {
        // Initialize variables
        int[] dataList = {2, 4, 6, 9, 5, 4, 5, 7, 12, 15, 21, 32, 45, 5, 6, 7, 12};
        double sum = 0;

        // Loop 1
        for (int num : dataList) {
            sum += num;
        }
        double mean = sum / dataList.length;
        System.out.printf("The mean of elements is %.2f\n", mean);

        System.out.print("Values greater than the mean are: ");
        // Loop 2
        for (int num : dataList) {
            if (num > mean) {
                System.out.print(num + " ");
            }
        }
    }
}
