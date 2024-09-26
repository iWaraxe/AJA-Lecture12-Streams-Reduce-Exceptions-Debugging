package com.coherentsolutions.advanced.java.section10;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the use of reduce() method to calculate total sales.
 */
public class Ex02SalesCalculator {

    /**
     * Main method to execute the total sales calculation example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of daily sales amounts
        List<Double> dailySales = Arrays.asList(150.0, 200.0, 99.99, 250.50, 300.0);

        // Calculate total sales using reduce() with a lambda expression
        double totalSales = dailySales.stream()
                .reduce(0.0, (sum, sale) -> sum + sale);

        // Alternatively, using method reference
        double totalSalesMethodRef = dailySales.stream()
                .reduce(0.0, Double::sum);

        // Output the results
        System.out.println("Total Sales (Lambda): $" + totalSales);
        System.out.println("Total Sales (Method Reference): $" + totalSalesMethodRef);
    }
}
