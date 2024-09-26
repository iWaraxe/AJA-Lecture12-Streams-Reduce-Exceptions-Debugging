package com.coherentsolutions.advanced.java.section50;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates calculating the sum of a list of integers using reduce().
 * Shows both sequential and parallel stream operations.
 */
public class Ex01SumReductionExample {

    /**
     * Main method to execute the sum reduction example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of numbers to sum
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sequential sum using reduce()
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        // Parallel sum using reduce()
        int parallelSum = numbers.parallelStream()
                .reduce(0, Integer::sum, Integer::sum);

        // Output the results
        System.out.println("Sequential Sum: " + sum);
        System.out.println("Parallel Sum: " + parallelSum);
    }
}
