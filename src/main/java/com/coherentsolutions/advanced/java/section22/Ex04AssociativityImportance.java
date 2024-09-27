package com.coherentsolutions.advanced.java.section22;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the importance of associativity in accumulator and combiner functions.
 * a + b + c = (a + b) + c = a + (b + c)
 */
public class Ex04AssociativityImportance {

    /**
     * Main method to show issues with non-associative operations in reduction.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers for subtraction operation
        List<Integer> numbers = Arrays.asList(10, 5, 2);

        // Using reduce() with subtraction, which is non-associative
        int resultSequential = numbers.stream()
                .reduce(0, (a, b) -> a - b);

        int resultParallel = numbers.parallelStream()
                .reduce(0, (a, b) -> a - b, (a, b) -> a - b);

        // Output the results
        System.out.println("Result with sequential stream: " + resultSequential);
        System.out.println("Result with parallel stream: " + resultParallel);
    }
}
