package com.coherentsolutions.advanced.java.section21.advanced;

import java.util.stream.LongStream;

/**
 * Demonstrates the performance difference between sequential and parallel reduction.
 */
public class Ex10ReductionWithParallelism {

    /**
     * Main method to compare sequential and parallel reduction.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        long n = 10_000_000L;

        // Sequential sum
        long startTime = System.currentTimeMillis();
        long sumSequential = LongStream.rangeClosed(1, n).sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential sum: " + sumSequential + " in " + (endTime - startTime) + " ms");

        // Parallel sum
        startTime = System.currentTimeMillis();
        long sumParallel = LongStream.rangeClosed(1, n).parallel().sum();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel sum: " + sumParallel + " in " + (endTime - startTime) + " ms");
    }
}
