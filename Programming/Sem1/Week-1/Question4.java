public class Question4 {
    public static void main(String[] args) {
        // Declare variables
        float hourlyRate = 9.80f;
        int hoursWorked = 42;
        double grossWeeklyWage;

        // Calculate the gross weekly wage
        grossWeeklyWage = hourlyRate * hoursWorked;

        // Print the gross weekly wage
        System.out.println("Hourly rate is " + hourlyRate);
        System.out.println("Hours worked is " + hoursWorked);
        System.out.println("Gross weekly is " + grossWeeklyWage);
    }
}
