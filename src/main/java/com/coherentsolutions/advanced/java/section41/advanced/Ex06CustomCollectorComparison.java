package com.coherentsolutions.advanced.java.section41.advanced;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Compares using reduce() and collect() for accumulating elements into a Set.
 */
public class Ex06CustomCollectorComparison {

    /**
     * Main method to execute the comparison between reduce() and collect().
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List with duplicate elements
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "grape");

        // Using reduce() to collect unique words into a Set (inefficient)
        Set<String> uniqueWordsWithReduce = words.stream()
                .reduce(
                        new HashSet<>(),                      // Identity (empty set)
                        (set, word) -> {                      // Accumulator
                            set.add(word);
                            return set;
                        },
                        (set1, set2) -> {                     // Combiner
                            set1.addAll(set2);
                            return set1;
                        }
                );

        // Using collect() to collect unique words into a Set (efficient)
        Set<String> uniqueWordsWithCollect = words.stream()
                .collect(Collectors.toSet());

        // Output the results
        System.out.println("Unique Words using reduce(): " + uniqueWordsWithReduce);
        System.out.println("Unique Words using collect(): " + uniqueWordsWithCollect);
    }
}
