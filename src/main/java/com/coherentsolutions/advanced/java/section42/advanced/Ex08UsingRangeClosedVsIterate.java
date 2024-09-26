package com.coherentsolutions.advanced.java.section42.advanced;

import java.util.stream.LongStream;

/**
 * Demonstrates the performance difference between using rangeClosed() and iterate() for generating streams.
 * rangeClosed() is optimized for sequential access and is more efficient compared to iterate().
 */
public class Ex08UsingRangeClosedVsIterate {

    /**
     * Main method to execute the rangeClosed vs iterate example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Using rangeClosed() which is optimized for sequential access
        long startTime = System.currentTimeMillis();
        long sumRangeClosed = LongStream.rangeClosed(1, 10_000_000).sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Sum using rangeClosed(): " + sumRangeClosed + " Time: " + (endTime - startTime) + " ms");

        // Using iterate() which is less efficient for large ranges
        startTime = System.currentTimeMillis();
        long sumIterate = LongStream.iterate(1, n -> n + 1).limit(10_000_000).sum();
        endTime = System.currentTimeMillis();
        System.out.println("Sum using iterate(): " + sumIterate + " Time: " + (endTime - startTime) + " ms");
    }
}
