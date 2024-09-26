package com.coherentsolutions.advanced.java.section21.advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates reduction with identity and accumulator in a parallel stream.
 */
public class Ex06ParallelStreamReduction {

    /**
     * Main method to execute reduction in a parallel stream.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers from 1 to 1000
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            numbers.add(i);
        }

        // Using reduce() in a parallel stream
        int sum = numbers.parallelStream()
                .reduce(0, Integer::sum);

        // Output the result
        System.out.println("Sum using parallel stream: " + sum);
    }
}
