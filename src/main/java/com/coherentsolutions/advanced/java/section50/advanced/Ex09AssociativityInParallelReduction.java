package com.coherentsolutions.advanced.java.section50.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the importance of associativity in parallel reduction operations.
 */
public class Ex09AssociativityInParallelReduction {

    /**
     * Main method to execute the associativity example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(2, 2, 2);

        // Sequential reduction using exponentiation (non-associative)
        int sequentialResult = numbers.stream()
                .reduce((a, b) -> (int) Math.pow(a, b))
                .orElse(-1);

        // Parallel reduction using exponentiation
        int parallelResult = numbers.parallelStream()
                .reduce((a, b) -> (int) Math.pow(a, b))
                .orElse(-1);

        // Output the results
        System.out.println("Sequential Exponentiation Result: " + sequentialResult);
        System.out.println("Parallel Exponentiation Result: " + parallelResult);
    }
}
