package com.coherentsolutions.advanced.java.section50.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates issues with non-associative operations in parallel streams.
 */
public class Ex07NonAssociativeOperationExample {

    /**
     * Main method to execute the non-associative operation example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of doubles
        List<Double> numbers = Arrays.asList(100.0, 10.0, 2.0);

        // Sequential reduction using division
        double sequentialResult = numbers.stream()
                .reduce((a, b) -> a / b)
                .orElse(Double.NaN);

        // Parallel reduction using division
        double parallelResult = numbers.parallelStream()
                .reduce((a, b) -> a / b)
                .orElse(Double.NaN);

        // Output the results
        System.out.println("Sequential Division Result: " + sequentialResult);
        System.out.println("Parallel Division Result: " + parallelResult);
    }
}
