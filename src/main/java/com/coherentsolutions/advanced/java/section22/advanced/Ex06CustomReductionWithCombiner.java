package com.coherentsolutions.advanced.java.section22.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates a custom reduction operation with identity, accumulator, and combiner.
 */
public class Ex06CustomReductionWithCombiner {

    /**
     * Main method to execute custom reduction example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of strings
        List<String> words = Arrays.asList("one", "two", "three", "four");

        // Custom reduction to count total number of characters in all words
        int totalLength = words.parallelStream()
                .reduce(0,
                        (partialLength, word) -> {
                            // Accumulator: adds length of word to partial length
                            return partialLength + word.length();
                        },
                        (len1, len2) -> {
                            // Combiner: combines two partial lengths
                            return len1 + len2;
                        });

        // Output the result
        System.out.println("Total number of characters: " + totalLength);
    }
}
