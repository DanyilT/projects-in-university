package secondPackage;

import firstPackage.Lab1Par1;

import java.util.Scanner;

public class Lab1Part2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please enter your initials: ");
        String inputInitials = scanner.nextLine();
        String name = Lab1Par1.getMyNameFromMyInitial(inputInitials.toUpperCase().toCharArray());

        if (name.equals("INPUT INITIAL NOT CORRECT"))
            System.out.println(name);
        else
            System.out.printf("My name is: %s\n", name);

        System.out.print("Please enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Please enter your last name: ");
        String lastName = scanner.nextLine();
        char[] initials = Lab1Par1.getMyInitialFromMyName(firstName, lastName);
        System.out.printf("My initials are: %c%c\n", initials[0], initials[1]);
    }
}
