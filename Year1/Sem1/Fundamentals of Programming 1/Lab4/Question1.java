public class Question1 {
    public static void main(String[] args) {
        // Declare Boolean variables
        boolean expr1Result, expr2Result, expr3Result, expr4Result, expr5Result;

        // Evaluate and assign results to variables
        expr1Result = (2 * 3 == 6) && (4 < 5);
        expr2Result = (3 > 1) || (5 < 3);
        expr3Result = (1 < 10) && (2 < 10) && (3 < 10);
        expr4Result = !(3 > 10) && (5 != 4);
        expr5Result = (10 >= 10) && (11 >= 10);

        // Print results
        System.out.println("(2 * 3 == 6) && (4 < 5) is " + expr1Result);
        System.out.println("(3 > 1) || (5 < 3) is " + expr2Result);
        System.out.println("(1 < 10) && (2 < 10) && (3 < 10) is " + expr3Result);
        System.out.println("!(3 > 10) && (5 != 4) is " + expr4Result);
        System.out.println("(10 >= 10) && (11 >= 10) is " + expr5Result);
    }
}
