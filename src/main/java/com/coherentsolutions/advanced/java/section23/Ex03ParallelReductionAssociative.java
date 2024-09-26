package com.coherentsolutions.advanced.java.section23;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates correct results in parallel reduction using an associative operation (addition).
 */
public class Ex03ParallelReductionAssociative {

    /**
     * Main method to execute parallel reduction with an associative operation.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers to sum
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sequential reduction using addition
        int sequentialResult = numbers.stream()
                .reduce(0, Integer::sum);

        // Parallel reduction using addition
        int parallelResult = numbers.parallelStream()
                .reduce(0, Integer::sum);

        // Output the results
        System.out.println("Sequential Result: " + sequentialResult);
        System.out.println("Parallel Result: " + parallelResult);

        // Both results should be equal
        if (sequentialResult == parallelResult) {
            System.out.println("Results are consistent using addition.");
        } else {
            System.out.println("Results differ, check associativity.");
        }
    }
}
