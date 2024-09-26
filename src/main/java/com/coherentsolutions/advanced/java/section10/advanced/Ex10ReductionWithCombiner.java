package com.coherentsolutions.advanced.java.section10.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the use of reduce() with an identity value, accumulator, and combiner.
 */
public class Ex10ReductionWithCombiner {

    /**
     * Main method to execute the reduction with combiner example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Use reduce() with identity, accumulator, and combiner in a parallel stream
        int sum = numbers.parallelStream()
                .reduce(0,
                        (partialSum, number) -> partialSum + number, // Accumulator
                        (sum1, sum2) -> sum1 + sum2); // Combiner

        // Output the result
        System.out.println("Sum: " + sum);
    }
}
