package com.coherentsolutions.advanced.java.section22.advanced;

import java.util.stream.LongStream;

/**
 * Demonstrates the performance difference between sequential and parallel reduction.
 */
public class Ex07ParallelReductionPerformance {

    /**
     * Main method to compare sequential and parallel reduction performance.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        long n = 10_000_000L;

        // Sequential sum
        long startTime = System.currentTimeMillis();
        long sumSequential = LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential sum: " + sumSequential + " computed in " + (endTime - startTime) + " ms");

        // Parallel sum
        startTime = System.currentTimeMillis();
        long sumParallel = LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
        endTime = System.currentTimeMillis();
        System.out.println("Parallel sum: " + sumParallel + " computed in " + (endTime - startTime) + " ms");
    }
}
