package com.coherentsolutions.advanced.java.section30.advanced;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

/**
 * Demonstrates creating a custom collector to collect elements into a Set.
 */
public class Ex05CustomCollectorExample {

    /**
     * Main method to execute the custom collector example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List with duplicate elements
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana");

        // Use a custom collector to collect unique words into a Set
        Set<String> uniqueWords = words.stream()
                .collect(Collector.of(
                        HashSet::new,                  // Supplier: creates a new HashSet
                        HashSet::add,                  // Accumulator: adds an element to the set
                        (set1, set2) -> {              // Combiner: merges two sets
                            set1.addAll(set2);
                            return set1;
                        }
                ));

        // Output the result
        System.out.println("Unique Words: " + uniqueWords);
    }
}
