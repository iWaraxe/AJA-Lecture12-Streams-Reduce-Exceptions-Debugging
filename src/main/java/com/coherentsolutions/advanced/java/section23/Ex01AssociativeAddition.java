package com.coherentsolutions.advanced.java.section23;

/**
 * Demonstrates the associativity property using addition.
 */
public class Ex01AssociativeAddition {

    /**
     * Main method to execute the associative addition example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Variables for demonstration
        int a = 1;
        int b = 2;
        int c = 3;

        // Associative addition
        int result1 = (a + b) + c; // Grouped as (a + b) + c
        int result2 = a + (b + c); // Grouped as a + (b + c)

        // Output the results
        System.out.println("Result1 ( (a + b) + c ): " + result1);
        System.out.println("Result2 ( a + (b + c) ): " + result2);

        // Both results should be equal
        if (result1 == result2) {
            System.out.println("Addition is associative.");
        } else {
            System.out.println("Addition is not associative.");
        }
    }
}
