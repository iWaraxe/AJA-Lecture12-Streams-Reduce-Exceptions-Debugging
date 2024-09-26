package com.coherentsolutions.advanced.java.section42;

import java.util.stream.LongStream;

/**
 * Demonstrates benchmarking of sequential and parallel streams to compare their performance.
 * Parallel streams can offer performance benefits for large datasets and computationally intensive tasks,
 * but may introduce overhead for smaller datasets.
 */
public class Ex05ParallelStreamBenchmark {

    /**
     * Main method to execute the parallel stream benchmark.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Dataset size
        long n = 10_000_000;

        // Sequential Stream
        long startTime = System.currentTimeMillis();
        long sequentialSum = LongStream.rangeClosed(1, n).sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential Sum: " + sequentialSum + " Time: " + (endTime - startTime) + " ms");

        // Parallel Stream
        startTime = System.currentTimeMillis();
        long parallelSum = LongStream.rangeClosed(1, n).parallel().sum();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel Sum: " + parallelSum + " Time: " + (endTime - startTime) + " ms");
    }
}
