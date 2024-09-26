package com.coherentsolutions.advanced.java.section30;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates grouping stream elements into a Map using collect().
 */
public class Ex04GroupingExample {

    /**
     * Main method to execute the grouping example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words
        List<String> words = Arrays.asList("apple", "banana", "cherry", "apricot", "blueberry");

        // Group words by their first letter
        Map<Character, List<String>> groupedWords = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));

        // Output the result
        System.out.println("Grouped Words: " + groupedWords);
    }
}
