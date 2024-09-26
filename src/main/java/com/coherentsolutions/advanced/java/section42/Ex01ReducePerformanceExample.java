package com.coherentsolutions.advanced.java.section42;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Demonstrates the inefficiency of using reduce() for mutable reductions.
 * Using reduce() to accumulate elements into a mutable container can lead to performance issues
 * due to frequent object creation and increased memory usage.
 */
public class Ex01ReducePerformanceExample {

    /**
     * Main method to execute the reduce performance example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words to collect
        List<String> words = Arrays.asList("Java", "Streams", "Performance", "Optimization");

        // Using reduce() to collect words into a list (inefficient)
        List<String> wordList = words.stream()
                .reduce(new ArrayList<>(),       // Identity should be List<String>
                        (List<String> list, String word) -> {  // Accumulator
                            // Creates a new list and adds the word
                            List<String> newList = new ArrayList<>(list);
                            newList.add(word);
                            return newList;
                        },
                        (List<String> list1, List<String> list2) -> { // Combiner
                            // Creates a new list and merges two lists
                            List<String> newList = new ArrayList<>(list1);
                            newList.addAll(list2);
                            return newList;
                        });

        // Output the result
        System.out.println("Collected Words using reduce(): " + wordList);
    }
}