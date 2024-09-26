package com.coherentsolutions.advanced.java.section21.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates a custom accumulator function in reduce().
 */
public class Ex11ReductionWithCustomAccumulator {

    /**
     * Main method to execute custom reduction.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        // Custom accumulator that counts total characters
        int totalCharacters = words.stream()
                .reduce(0,
                        (total, word) -> total + word.length(),  // Accumulator
                        Integer::sum);                           // Combiner

        // Output the result
        System.out.println("Total number of characters: " + totalCharacters);
    }
}
