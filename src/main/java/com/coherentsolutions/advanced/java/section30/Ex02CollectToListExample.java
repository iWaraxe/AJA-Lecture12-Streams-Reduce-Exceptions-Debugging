package com.coherentsolutions.advanced.java.section30;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates using collect() to collect elements into a List.
 * This is the preferred and efficient way to collect stream elements into a collection.
 */
public class Ex02CollectToListExample {

    /**
     * Main method to execute the collect to List example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words
        List<String> words = Arrays.asList("Java", "Streams", "are", "powerful");

        // Collect words into a list using collect()
        List<String> wordList = words.stream()
                .collect(Collectors.toList());

        // Output the result
        System.out.println("Words collected using collect(): " + wordList);
    }
}
