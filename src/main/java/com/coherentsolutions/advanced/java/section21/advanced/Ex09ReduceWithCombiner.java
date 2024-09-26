package com.coherentsolutions.advanced.java.section21.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the use of reduce() with identity, accumulator, and combiner in a parallel stream.
 */
public class Ex09ReduceWithCombiner {

    /**
     * Main method to execute reduction with combiner.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of strings
        List<String> words = Arrays.asList("A", "B", "C", "D");

        // Using reduce() with identity, accumulator, and combiner
        String concatenated = words.parallelStream()
                .reduce("",
                        (s1, s2) -> s1 + s2,            // Accumulator
                        (s1, s2) -> s1 + s2);           // Combiner

        // Output the result
        System.out.println("Concatenated String: " + concatenated);
    }
}
