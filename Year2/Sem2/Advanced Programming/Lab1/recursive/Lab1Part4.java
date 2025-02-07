package recursive;

public class Lab1Part4 {
    public static void main(String[] args) {
        Lab1Part4 lab = new Lab1Part4();
        System.out.println("Sum from 10 to 1: " + lab.recursiveSum(10));
        System.out.println("Alphabet from 'a' to 'z': " + lab.buildAlphabetString('a'));
    }

    /**
     * This method calculates the sum of numbers from the given number to 1
     * @param number the number to start the sum from
     * @return the sum of numbers from the given number to 1
     */
    public int recursiveSum(int number) {
        if (number <= 1) {
            return number;
        }
        return number + recursiveSum(number - 1);
    }

    /**
     * This method builds a string of the alphabet from the given character to 'z'
     * @param character the character to start the alphabet from
     * @return the string of the alphabet from the given character to 'z'
     */
    public String buildAlphabetString(char character) {
        if (character > 'z') {
            return "";
        }
        return character + buildAlphabetString((char) (character + 1));
    }
}
