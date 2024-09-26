package com.coherentsolutions.advanced.java.section43;

import java.util.*;
import java.util.stream.*;
import java.time.Duration;
import java.time.Instant;

/**
 * Compares the performance of reduce() vs. collect() methods in Java Streams.
 * This example demonstrates how using collect() can be more efficient than reduce()
 * for certain operations, such as summing a large list of integers.
 */
public class Ex01PerformanceComparison {

    /**
     * Main method to execute the performance comparison.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Generate a large list of random integers between 1 and 100
        List<Integer> numbers = new Random().ints(10_000_000, 1, 100)
                .boxed()
                .collect(Collectors.toList());

        // Measure performance of reduce() for summing numbers
        Instant start = Instant.now();
        int sumWithReduce = numbers.stream()
                .reduce(0, Integer::sum);
        Instant end = Instant.now();
        System.out.println("Sum with reduce(): " + sumWithReduce +
                ", Time taken: " + Duration.between(start, end).toMillis() + " ms");

        // Measure performance of sum() on IntStream (collect() equivalent)
        start = Instant.now();
        int sumWithIntStream = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        end = Instant.now();
        System.out.println("Sum with IntStream sum(): " + sumWithIntStream +
                ", Time taken: " + Duration.between(start, end).toMillis() + " ms");
    }
}
