package com.coherentsolutions.advanced.java.section42.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates using Collectors.joining() to concatenate strings with a delimiter.
 * Collectors.joining() is optimized for string concatenation and provides better performance
 * compared to manual concatenation using reduce().
 */
public class Ex11UsingCollectorsJoining {

    /**
     * Main method to execute the joining collector example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words to join
        List<String> words = Arrays.asList("Java", "Streams", "are", "powerful");

        // Join words into a single string with spaces
        String sentence = words.stream()
                .collect(Collectors.joining(" "));

        // Output the result
        System.out.println("Joined Sentence: " + sentence);
    }
}
