package com.coherentsolutions.advanced.java.section43.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates the principle of avoiding premature optimization.
 * Focuses on writing clear and maintainable code first, then optimizing after profiling.
 */
public class Ex05AvoidingPrematureOptimization {

    /**
     * Main method to execute the premature optimization example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers to process
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Clear and maintainable approach: using collect()
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        // Output the result
        System.out.println("Even Numbers: " + evenNumbers);

        /**
         * Optimization Consideration:
         * Instead of using collect(), one might be tempted to use reduce() for certain operations.
         * However, unless profiling shows a performance bottleneck, it's better to keep the code
         * simple and readable.
         */
    }
}
