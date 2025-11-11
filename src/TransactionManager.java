/*
Created by: Dany
Created on 12/03/2024 : 18:17
This is program to manage the transactions of the coffee shop
*/

import java.io.*;
import java.util.*;

public class TransactionManager {
    // If run via terminal, the path should be "../data/inventory.csv", but if run via IDE, the path should be "data/inventory.csv" or set Working Directory to "CoffeeShop"
    private static final String TRANSACTION_FILE_PATH = "../data/transactions.csv";

    // Method to append transactions to the transactions file
    public static void saveTransactions(List<Transaction> transactions) {
        try (FileWriter fileWriter = new FileWriter(TRANSACTION_FILE_PATH, true);
             PrintWriter out = new PrintWriter(fileWriter)) {
            for (Transaction transaction : transactions) {
                out.println(transaction);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving transactions: " + e.getMessage());
        }
    }
}
