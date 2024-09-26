package com.coherentsolutions.advanced.java.section43;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates immutable reduction using the reduce() method to concatenate strings.
 * This approach creates new String objects at each step, which can be inefficient
 * for large lists of strings.
 */
public class Ex02ImmutableReductionExample {

    /**
     * Main method to execute the immutable reduction example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words to concatenate
        List<String> words = Arrays.asList("Java", "Streams", "are", "powerful");

        // Concatenate words using reduce() (immutable reduction)
        String sentence = words.stream()
                .reduce("", (partialString, word) -> partialString + " " + word)
                .trim(); // Remove leading space

        // Output the result
        System.out.println("Concatenated Sentence using reduce(): " + sentence);
    }
}
