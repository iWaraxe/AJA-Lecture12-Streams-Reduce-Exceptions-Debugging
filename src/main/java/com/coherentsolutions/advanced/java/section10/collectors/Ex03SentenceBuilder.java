package com.coherentsolutions.advanced.java.section10.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates the use of collect() method to concatenate a list of words into a sentence.
 */
public class Ex03SentenceBuilder {

    /**
     * Main method to execute the sentence building example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words
        List<String> words = Arrays.asList("Java", "streams", "are", "powerful");

        // Concatenate words into a sentence using collect()
        String sentence = words.stream()
                .collect(Collectors.joining(" "));

        // Output the result
        System.out.println("Sentence: " + sentence);
    }
}
