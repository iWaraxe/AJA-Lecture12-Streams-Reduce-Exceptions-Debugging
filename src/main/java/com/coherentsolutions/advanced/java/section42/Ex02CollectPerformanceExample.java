package com.coherentsolutions.advanced.java.section42;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates the efficiency of using collect() for mutable reductions.
 * The collect() method is optimized for accumulating elements into mutable containers
 * like List, Set, or Map, avoiding unnecessary object creation.
 */
public class Ex02CollectPerformanceExample {

    /**
     * Main method to execute the collect performance example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words to collect
        List<String> words = Arrays.asList("Java", "Streams", "Performance", "Optimization");

        // Using collect() to collect words into a list (efficient)
        List<String> wordList = words.stream()
                .collect(Collectors.toList());

        // Output the result
        System.out.println("Collected Words using collect(): " + wordList);
    }
}
