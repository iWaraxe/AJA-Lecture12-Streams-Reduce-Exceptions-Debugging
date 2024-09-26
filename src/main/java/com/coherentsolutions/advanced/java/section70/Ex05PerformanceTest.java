package com.coherentsolutions.advanced.java.section70;

import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates performance testing of stream operations.
 */
public class Ex05PerformanceTest {

    /**
     * Tests the performance of summing a large range of numbers using a parallel stream.
     */
    @Test
    public void testStreamPerformance() {
        long limit = 10_000_000;
        long expectedSum = (limit * (limit + 1)) / 2; // Formula for sum of first n natural numbers

        long startTime = System.currentTimeMillis();

        // Sum numbers from 1 to limit using a parallel stream
        long sum = LongStream.rangeClosed(1, limit)
                .parallel()
                .reduce(0L, Long::sum);

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream: " + (endTime - startTime) + " ms");

        // Assert that the sum is as expected
        assertEquals(expectedSum, sum);
    }
}
