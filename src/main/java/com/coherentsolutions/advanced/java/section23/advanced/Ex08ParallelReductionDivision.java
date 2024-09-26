package com.coherentsolutions.advanced.java.section23.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates issues in parallel reduction using a non-associative operation (division).
 */
public class Ex08ParallelReductionDivision {

    /**
     * Main method to execute parallel reduction with division.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of doubles
        List<Double> numbers = Arrays.asList(100.0, 2.0, 5.0);

        // Sequential reduction using division
        double sequentialResult = numbers.stream()
                .reduce(1.0, (a, b) -> a / b);

        // Parallel reduction using division
        double parallelResult = numbers.parallelStream()
                .reduce(1.0, (a, b) -> a / b);

        // Output the results
        System.out.println("Sequential Result: " + sequentialResult);
        System.out.println("Parallel Result: " + parallelResult);

        // Results may differ due to non-associativity
        if (sequentialResult == parallelResult) {
            System.out.println("Results are consistent using division.");
        } else {
            System.out.println("Results differ due to non-associativity of division.");
        }
    }
}
