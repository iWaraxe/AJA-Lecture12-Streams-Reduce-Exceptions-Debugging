package com.coherentsolutions.advanced.java.section23;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates incorrect results in parallel reduction using a non-associative operation (subtraction).
 */
public class Ex04ParallelReductionNonAssociative {

    /**
     * Main method to execute parallel reduction with a non-associative operation.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sequential reduction using subtraction
        int sequentialResult = numbers.stream()
                .reduce(0, (a, b) -> a - b);

        // Parallel reduction using subtraction
        int parallelResult = numbers.parallelStream()
                .reduce(0, (a, b) -> a - b);

        // Output the results
        System.out.println("Sequential Result: " + sequentialResult);
        System.out.println("Parallel Result: " + parallelResult);

        // Results may differ due to non-associativity
        if (sequentialResult == parallelResult) {
            System.out.println("Results are consistent using subtraction.");
        } else {
            System.out.println("Results differ due to non-associativity of subtraction.");
        }
    }
}
