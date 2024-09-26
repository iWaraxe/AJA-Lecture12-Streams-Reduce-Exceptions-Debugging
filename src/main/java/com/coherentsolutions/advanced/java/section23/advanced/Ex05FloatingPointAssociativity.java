package com.coherentsolutions.advanced.java.section23.advanced;

/**
 * Demonstrates issues with associativity in floating-point arithmetic.
 */
public class Ex05FloatingPointAssociativity {

    /**
     * Main method to show floating-point associativity issues.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Variables for demonstration
        double a = 1e16;
        double b = -1e16;
        double c = 1.0;

        // Grouped as (a + b) + c
        double result1 = (a + b) + c;

        // Grouped as a + (b + c)
        double result2 = a + (b + c);

        // Output the results
        System.out.println("Result1 ( (a + b) + c ): " + result1);
        System.out.println("Result2 ( a + (b + c) ): " + result2);

        // Results may differ due to floating-point precision errors
        if (result1 == result2) {
            System.out.println("Floating-point addition appears associative.");
        } else {
            System.out.println("Floating-point addition is not associative due to precision errors.");
        }
    }
}
