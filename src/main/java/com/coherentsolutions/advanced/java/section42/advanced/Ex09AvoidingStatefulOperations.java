package com.coherentsolutions.advanced.java.section42.advanced;

import java.util.stream.IntStream;

/**
 * Demonstrates avoiding stateful operations in streams to maintain better performance.
 * Stateful operations like sorted() can introduce additional overhead, especially in parallel streams.
 */
public class Ex09AvoidingStatefulOperations {

    /**
     * Main method to execute the stateful operations example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Generate a stream of numbers from 1 to 10,000
        IntStream numbers = IntStream.rangeClosed(1, 10_000);

        // Using a stateful operation (sorted) can affect performance
        long startTime = System.currentTimeMillis();
        long count = numbers
                .parallel()
                .sorted()    // Stateful operation: requires additional processing
                .count();
        long endTime = System.currentTimeMillis();

        // Output the result
        System.out.println("Count: " + count + " Time with sorted(): " + (endTime - startTime) + " ms");
    }
}
