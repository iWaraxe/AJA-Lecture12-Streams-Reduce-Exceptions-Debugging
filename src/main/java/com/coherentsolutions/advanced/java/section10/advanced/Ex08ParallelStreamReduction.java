package com.coherentsolutions.advanced.java.section10.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates reduction in parallel streams and the importance of associativity.
 */
public class Ex08ParallelStreamReduction {

    /**
     * Main method to execute the parallel stream reduction example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sum the numbers using reduce() in a parallel stream
        int sum = numbers.parallelStream()
                .reduce(0, Integer::sum);

        // Output the result
        System.out.println("Sum: " + sum);

        // Concatenate numbers into a string using reduce()
        String concatenated = numbers.parallelStream()
                .map(Object::toString)
                .reduce("", (a, b) -> a + b);

        // Output the result
        System.out.println("Concatenated String: " + concatenated);
    }
}
