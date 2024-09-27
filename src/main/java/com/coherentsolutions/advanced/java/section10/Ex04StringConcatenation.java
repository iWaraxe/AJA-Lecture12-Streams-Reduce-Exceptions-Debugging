package com.coherentsolutions.advanced.java.section10;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the use of reduce() method to concatenate strings.
 */
public class Ex04StringConcatenation {

    /**
     * Main method to execute the string concatenation example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words
        List<String> words = Arrays.asList(" Java", "streams", "are", "powerful ");

        // Concatenate words using reduce()
        String sentence = words.stream()
                .reduce("", (partialString, word) -> partialString + " " + word)
                .trim(); // Remove leading and trailing whitespace

        // Output the result
        System.out.println("Sentence: " + sentence);
    }
}
