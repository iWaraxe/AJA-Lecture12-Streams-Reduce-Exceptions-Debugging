package com.coherentsolutions.advanced.java.section21.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates issues with non-associative accumulators in parallel streams.
 */
public class Ex07NonAssociativeReductionIssue {

    /**
     * Main method to show problems with non-associative accumulator in parallel streams.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of doubles
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0);

        // Non-associative accumulator function (subtraction)
        double resultSequential = numbers.stream()
                .reduce(0.0, (a, b) -> a - b);

        double resultParallel = numbers.parallelStream()
                .reduce(0.0, (a, b) -> a - b);

        // Output the results
        System.out.println("Result with sequential stream: " + resultSequential);
        System.out.println("Result with parallel stream: " + resultParallel);
    }
}
