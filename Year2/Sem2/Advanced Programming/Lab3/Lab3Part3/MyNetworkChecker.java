package Lab3Part3;

import Lab3Part3.exception.BalanceBelowLimitException;
import Lab3Part3.exception.WrongNetworkException;

public class MyNetworkChecker {
    private static final String MY_NETWORK = "Kyivstar";
    private static final int MIN_BALANCE = 1;

    public static void main(String[] args) {
        // Test the checkMyMobileNetwork method
        try {
            checkMyMobileNetwork("Mobilych");
        } catch (WrongNetworkException e) {
            System.err.println("Caught an exception");
            e.printStackTrace();
        }

        // Test the checkMyBalance method
        try {
            checkMyBalance(0);
        } catch (BalanceBelowLimitException e) {
            System.err.println("Caught an exception");
            e.printStackTrace();
        }
    }

    /**
     * Checks if the provided mobile network matches the required network.
     * @param inputNetwork the name of the mobile network to check
     * @throws WrongNetworkException if the provided network does not match the expected network
     */
    public static void checkMyMobileNetwork(String inputNetwork) throws WrongNetworkException {
        if (!MY_NETWORK.equals(inputNetwork)) {
            throw new WrongNetworkException("Network is incorrect: " + inputNetwork);
        }
        System.out.println("Network is correct: " + inputNetwork);
    }

    /**
     * Checks if the provided balance is above the minimum limit.
     * @param balance the balance to check
     * @throws BalanceBelowLimitException if the balance is below the minimum limit
     */
    public static void checkMyBalance(int balance) throws BalanceBelowLimitException {
        if (balance < MIN_BALANCE) {
            throw new BalanceBelowLimitException("Balance is below the minimum limit: " + balance);
        }
        System.out.println("Balance is sufficient: " + balance);
    }
}
