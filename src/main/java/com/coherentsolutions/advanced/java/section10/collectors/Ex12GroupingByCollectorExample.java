package com.coherentsolutions.advanced.java.section10.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates grouping stream elements using Collectors.groupingBy().
 */
public class Ex12GroupingByCollectorExample {

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
        groupedWords.forEach((letter, wordList) -> {
            System.out.println("Words starting with '" + letter + "': " + wordList);
        });
    }
}
