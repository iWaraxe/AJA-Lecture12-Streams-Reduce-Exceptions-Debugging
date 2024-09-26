package com.coherentsolutions.advanced.java.section42.advanced;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

/**
 * Demonstrates using a custom collector for accumulating elements into a Set.
 * Custom collectors can be tailored for specific accumulation needs, potentially improving performance.
 */
public class Ex06CustomCollectorPerformance {

    /**
     * Main method to execute the custom collector performance example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List with duplicate elements
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");

        // Using a custom collector to collect unique words into a Set
        Set<String> uniqueWords = words.stream()
                .collect(Collector.of(
                        HashSet::new,    // Supplier: creates a new HashSet
                        Set::add,        // Accumulator: adds an element to the set
                        (set1, set2) -> { // Combiner: merges two sets
                            set1.addAll(set2);
                            return set1;
                        }
                ));

        // Output the result
        System.out.println("Unique Words: " + uniqueWords);
    }
}
