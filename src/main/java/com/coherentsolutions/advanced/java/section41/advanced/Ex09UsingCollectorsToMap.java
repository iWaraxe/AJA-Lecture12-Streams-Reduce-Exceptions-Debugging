package com.coherentsolutions.advanced.java.section41.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates using Collectors.toMap() to create a Map from stream elements.
 */
public class Ex09UsingCollectorsToMap {

    /**
     * Main method to execute the toMap collector example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of strings
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        // Create a Map with word as key and its length as value
        Map<String, Integer> wordLengthMap = words.stream()
                .collect(Collectors.toMap(
                        word -> word,          // Key mapper: the word itself
                        word -> word.length()  // Value mapper: length of the word
                ));

        // Output the result
        System.out.println("Word Length Map: " + wordLengthMap);
    }
}
