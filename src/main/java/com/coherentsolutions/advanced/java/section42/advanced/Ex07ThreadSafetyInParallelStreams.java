package com.coherentsolutions.advanced.java.section42.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Demonstrates the pitfalls of using shared mutable state in parallel streams.
 * Shared mutable containers can lead to race conditions and unpredictable results.
 */
public class Ex07ThreadSafetyInParallelStreams {

    /**
     * Main method to execute the thread safety example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Shared mutable list (not thread-safe)
        List<Integer> resultList = new ArrayList<>();

        // Attempting to add elements to resultList using a parallel stream
        numbers.parallelStream().forEach(n -> resultList.add(n));

        // Output the result
        System.out.println("Result List: " + resultList);
    }
}
