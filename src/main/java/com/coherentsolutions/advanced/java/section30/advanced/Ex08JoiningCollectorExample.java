package com.coherentsolutions.advanced.java.section30.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates using Collectors.joining() to concatenate strings.
 */
public class Ex08JoiningCollectorExample {

    /**
     * Main method to execute the joining collector example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words
        List<String> words = Arrays.asList("Java", "is", "awesome");

        // Join words into a single string with spaces
        String sentence = words.stream()
                .collect(Collectors.joining(" "));

        // Output the result
        System.out.println("Sentence: " + sentence);
    }
}
