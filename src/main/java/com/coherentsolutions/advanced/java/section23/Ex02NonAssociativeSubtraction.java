package com.coherentsolutions.advanced.java.section23;

/**
 * Demonstrates the non-associativity property using subtraction.
 */
public class Ex02NonAssociativeSubtraction {

    /**
     * Main method to execute the non-associative subtraction example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Variables for demonstration
        int a = 10;
        int b = 5;
        int c = 2;

        // Non-associative subtraction
        int result1 = (a - b) - c; // Grouped as (a - b) - c
        int result2 = a - (b - c); // Grouped as a - (b - c)

        // Output the results
        System.out.println("Result1 ( (a - b) - c ): " + result1);
        System.out.println("Result2 ( a - (b - c) ): " + result2);

        // Results are different, showing non-associativity
        if (result1 == result2) {
            System.out.println("Subtraction is associative.");
        } else {
            System.out.println("Subtraction is not associative.");
        }
    }
}
