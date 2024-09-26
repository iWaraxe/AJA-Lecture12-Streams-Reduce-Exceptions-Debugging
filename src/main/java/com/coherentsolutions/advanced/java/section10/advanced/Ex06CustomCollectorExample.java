package com.coherentsolutions.advanced.java.section10.advanced;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Demonstrates creating a custom collector using Collectors.collectingAndThen().
 */
public class Ex06CustomCollectorExample {

    /**
     * Main method to execute the custom collector example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words with duplicates
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");

        // Use a custom collector to collect unique uppercase words
        Set<String> uniqueUppercaseWords = words.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toSet(), // Collect to a Set to remove duplicates
                        set -> {
                            // Convert all words to uppercase
                            Set<String> uppercaseSet = new HashSet<>();
                            for (String word : set) {
                                uppercaseSet.add(word.toUpperCase());
                            }
                            return uppercaseSet;
                        }
                ));

        // Output the result
        System.out.println("Unique Uppercase Words: " + uniqueUppercaseWords);
    }
}
