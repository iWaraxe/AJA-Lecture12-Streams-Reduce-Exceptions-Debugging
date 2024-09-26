package com.coherentsolutions.advanced.java.section41.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates using Collectors.groupingBy() to group elements based on a classifier.
 */
public class Ex10UsingCollectorsGroupingBy {

    /**
     * Main method to execute the groupingBy collector example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words
        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry");

        // Group words by their first letter
        Map<Character, List<String>> groupedWords = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));

        // Output the result
        System.out.println("Grouped Words: " + groupedWords);
    }
}
