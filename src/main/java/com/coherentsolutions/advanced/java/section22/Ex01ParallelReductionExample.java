package com.coherentsolutions.advanced.java.section22;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the use of reduce() with identity, accumulator, and combiner
 * in a parallel stream to sum integers.
 */
public class Ex01ParallelReductionExample {

    /**
     * Main method to execute the parallel reduction example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers to sum
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using reduce() with identity, accumulator, and combiner in a parallel stream
        int sum = numbers.parallelStream()
                .reduce(0,
                        (partialSum, number) -> {
                            // Accumulator: adds number to partial sum
                            return partialSum + number;
                        },
                        (sum1, sum2) -> {
                            // Combiner: combines two partial sums
                            return sum1 + sum2;
                        });

        // Alternatively, using method references for brevity
        int sumMethodRef = numbers.parallelStream()
                .reduce(0, Integer::sum, Integer::sum);

        // Output the results
        System.out.println("Sum using lambda expressions: " + sum);
        System.out.println("Sum using method references: " + sumMethodRef);
    }
}
