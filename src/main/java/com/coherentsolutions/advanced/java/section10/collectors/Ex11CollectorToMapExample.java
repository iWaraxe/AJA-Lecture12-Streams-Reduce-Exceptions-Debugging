package com.coherentsolutions.advanced.java.section10.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates using collectors to create a Map from a stream.
 */
public class Ex11CollectorToMapExample {

    /**
     * Main method to execute the collector to Map example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of strings
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        // Create a Map with word as key and its length as value
        Map<String, Integer> wordLengthMap = words.stream()
                .collect(Collectors.toMap(
                        word -> word,          // Key mapper
                        word -> word.length()  // Value mapper
                ));

        // Output the result
        System.out.println("Word Length Map: " + wordLengthMap);
    }
}
