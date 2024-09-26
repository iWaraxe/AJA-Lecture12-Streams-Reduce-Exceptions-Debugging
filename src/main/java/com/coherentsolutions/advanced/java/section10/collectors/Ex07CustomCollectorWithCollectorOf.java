package com.coherentsolutions.advanced.java.section10.collectors;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

/**
 * Demonstrates creating a custom collector using Collector.of().
 */
public class Ex07CustomCollectorWithCollectorOf {

    /**
     * Main method to execute the custom collector example using Collector.of().
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words with duplicates
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");

        // Use a custom collector to collect unique uppercase words
        Set<String> uniqueUppercaseWords = words.stream()
                .collect(Collector.of(
                        HashSet::new, // Supplier: create a new HashSet
                        (set, word) -> set.add(word.toUpperCase()), // Accumulator: add uppercase word to the set
                        (set1, set2) -> { // Combiner: merge two sets
                            set1.addAll(set2);
                            return set1;
                        }
                ));

        // Output the result
        System.out.println("Unique Uppercase Words: " + uniqueUppercaseWords);
    }
}
