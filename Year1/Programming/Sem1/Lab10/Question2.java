import java.util.Scanner;
import java.util.Arrays;

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter string 1: ");
        String s1 = scanner.nextLine();
        System.out.print("Please enter string 2: ");
        String s2 = scanner.nextLine();
        String[] strings = {s1, s2};
        Arrays.sort(strings);
        for (String s : strings) {
            System.out.print(s + " ");
        }
    }
}
