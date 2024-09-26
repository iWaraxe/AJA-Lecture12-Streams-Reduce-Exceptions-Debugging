package com.coherentsolutions.advanced.java.section43.advanced;

import java.util.*;
import java.util.stream.*;
import java.time.Duration;
import java.time.Instant;

/**
 * Demonstrates how to measure performance using profiling tools.
 * Although this example uses simple timing, in real-world scenarios,
 * profiling tools like Java Flight Recorder, VisualVM, or JProfiler
 * should be used for more detailed analysis.
 */
public class Ex04UsingProfilingTools {

    /**
     * Main method to execute the profiling example.
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

        /**
         * Note:
         * For more accurate and detailed performance measurements,
         * consider using profiling tools like Java Flight Recorder,
         * VisualVM, or JProfiler. These tools provide insights into
         * memory usage, CPU consumption, and can help identify bottlenecks.
         */
    }
}
