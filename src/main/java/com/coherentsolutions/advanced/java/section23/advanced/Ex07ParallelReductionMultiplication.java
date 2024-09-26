package com.coherentsolutions.advanced.java.section23.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates parallel reduction using multiplication, an associative operation.
 */
public class Ex07ParallelReductionMultiplication {

    /**
     * Main method to execute parallel reduction with multiplication.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers to multiply
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sequential reduction using multiplication
        int sequentialResult = numbers.stream()
                .reduce(1, (a, b) -> a * b);

        // Parallel reduction using multiplication
        int parallelResult = numbers.parallelStream()
                .reduce(1, (a, b) -> a * b);

        // Output the results
        System.out.println("Sequential Result: " + sequentialResult);
        System.out.println("Parallel Result: " + parallelResult);

        // Both results should be equal
        if (sequentialResult == parallelResult) {
            System.out.println("Results are consistent using multiplication.");
        } else {
            System.out.println("Results differ, check associativity.");
        }
    }
}
