package com.coherentsolutions.advanced.java.section80.advanced;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates measuring and comparing the performance of sequential and parallel streams.
 */
public class Ex10PerformanceComparison {

    public static void main(String[] args) {
        // Generate a large list of random integers
        List<Integer> numbers = Stream.generate(() -> (int) (Math.random() * 1000))
                .limit(10_000_000)
                .collect(Collectors.toList());

        // Sequential sum
        long startTime = System.currentTimeMillis();
        long sumSequential = numbers.stream()
                .mapToLong(Integer::longValue)
                .sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential sum time: " + (endTime - startTime) + " ms");

        // Parallel sum
        startTime = System.currentTimeMillis();
        long sumParallel = numbers.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel sum time: " + (endTime - startTime) + " ms");
    }
}
