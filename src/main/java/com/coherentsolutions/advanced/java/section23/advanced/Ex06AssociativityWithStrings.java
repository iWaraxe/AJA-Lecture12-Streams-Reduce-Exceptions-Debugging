package com.coherentsolutions.advanced.java.section23.advanced;

/**
 * Demonstrates associativity with string concatenation.
 */
public class Ex06AssociativityWithStrings {

    /**
     * Main method to demonstrate associativity in string concatenation.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Strings for demonstration
        String a = "Hello";
        String b = " ";
        String c = "World";

        // Grouped as (a + b) + c
        String result1 = (a + b) + c;

        // Grouped as a + (b + c)
        String result2 = a + (b + c);

        // Output the results
        System.out.println("Result1: '" + result1 + "'");
        System.out.println("Result2: '" + result2 + "'");

        // Both results should be equal
        if (result1.equals(result2)) {
            System.out.println("String concatenation is associative.");
        } else {
            System.out.println("String concatenation is not associative.");
        }
    }
}
