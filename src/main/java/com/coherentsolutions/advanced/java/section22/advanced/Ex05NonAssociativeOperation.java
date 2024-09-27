package com.coherentsolutions.advanced.java.section22.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates problems with non-associative operations in parallel reduction.
 */
public class Ex05NonAssociativeOperation {

    /**
     * Main method to show issues with non-associative operations.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of floating-point numbers
        List<Double> numbers = Arrays.asList(100.0, 10.0, 2.0);

        // Using reduce() with division, which is non-associative
        double resultSequential = numbers.stream()
                .reduce(10000., (a, b) -> a / b);

        double resultParallel = numbers.parallelStream()
                .reduce(10000.0, (a, b) -> a / b, (a, b) -> a / b);

        // Output the results
        System.out.println("Result with sequential stream: " + resultSequential);
        System.out.println("Result with parallel stream: " + resultParallel);
    }
}
