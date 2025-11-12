package firstPackage;

import java.util.Scanner;

public class Lab1Par1 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String firstName = "Danyil";
    private static final String lastName = "Tymchuk";
    private static final String studentNumber = "B00167321";

    public static void main(String[] args) {
        System.out.printf("My name is %s %s and my student number is %s\n", firstName, lastName, studentNumber);
        System.out.print("Please enter your initials: ");
        String inputInitials = scanner.nextLine();
        String name = getMyNameFromMyInitial(inputInitials.toUpperCase().toCharArray());

        if (name.equals("INPUT INITIAL NOT CORRECT"))
            System.out.println(name);
        else
            System.out.printf("My name is: %s\n", name);
    }

    /**
     * This method takes initials as input and returns the name of the student if the initials are correct
     * @param initials initials of the student
     * @return name of the student if initials are correct, otherwise "INPUT INITIAL NOT CORRECT"
     */
    public static String getMyNameFromMyInitial(char[] initials) {
        return initials[0] == firstName.charAt(0) && initials[1] == lastName.charAt(0) ? firstName + " " + lastName : "INPUT INITIAL NOT CORRECT";
    }

    /**
     * This method takes the first name and last name of the student as input and returns the initials of the student
     * @param firstName first name of the student
     * @param lastName last name of the student
     * @return initials of the student
     */
    public static char[] getMyInitialFromMyName(String firstName, String lastName) {
        return new char[] {firstName.toUpperCase().charAt(0), lastName.toUpperCase().charAt(0)};
    }
}
