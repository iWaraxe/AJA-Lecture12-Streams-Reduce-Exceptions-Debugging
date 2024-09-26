package com.coherentsolutions.advanced.java.section42;

import java.util.stream.IntStream;

/**
 * Demonstrates the use of primitive streams to avoid boxing/unboxing overhead.
 * Using primitive streams like IntStream, LongStream, and DoubleStream can improve performance
 * by eliminating the need for boxing and unboxing of primitive types.
 */
public class Ex03PrimitiveStreamExample {

    /**
     * Main method to execute the primitive stream example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Sum of integers from 1 to 1,000,000 using Stream<Integer> (with boxing)
        long startTime = System.currentTimeMillis();
        int sumWithStream = IntStream.rangeClosed(1, 1_000_000)
                .boxed() // Converts IntStream to Stream<Integer>, introducing boxing
                .reduce(0, Integer::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("Sum with Stream<Integer>: " + sumWithStream + " Time: " + (endTime - startTime) + "ms");

        // Sum of integers from 1 to 1,000,000 using IntStream (primitive)
        startTime = System.currentTimeMillis();
        int sumWithIntStream = IntStream.rangeClosed(1, 1_000_000)
                .sum(); // Uses primitive operations, avoiding boxing
        endTime = System.currentTimeMillis();
        System.out.println("Sum with IntStream: " + sumWithIntStream + " Time: " + (endTime - startTime) + "ms");
    }
}
