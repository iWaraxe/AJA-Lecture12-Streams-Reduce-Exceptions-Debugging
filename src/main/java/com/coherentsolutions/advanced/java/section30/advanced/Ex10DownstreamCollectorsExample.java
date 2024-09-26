package com.coherentsolutions.advanced.java.section30.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates using downstream collectors with groupingBy().
 */
public class Ex10DownstreamCollectorsExample {

    /**
     * Main method to execute the downstream collectors example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words
        List<String> words = Arrays.asList("apple", "ant", "banana", "bat", "cat", "car");

        // Group words by their first letter and count the number of words in each group
        Map<Character, Long> letterCounts = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word.charAt(0),           // Classifier function
                        Collectors.counting()             // Downstream collector to count elements
                ));

        // Output the result
        System.out.println("Letter Counts: " + letterCounts);
    }
}
