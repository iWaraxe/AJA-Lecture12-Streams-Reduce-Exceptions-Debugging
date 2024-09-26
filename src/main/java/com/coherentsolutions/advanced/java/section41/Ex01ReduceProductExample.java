package com.coherentsolutions.advanced.java.section41;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the use of reduce() method to calculate the product of numbers.
 */
public class Ex01ReduceProductExample {

    /**
     * Main method to execute the reduce product example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using reduce() to calculate the product
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);

        // Alternatively, using method reference (not applicable for multiplication)
        // Since there's no built-in method reference for multiplication, we use a lambda

        // Output the result
        System.out.println("Product of numbers: " + product);
    }
}
