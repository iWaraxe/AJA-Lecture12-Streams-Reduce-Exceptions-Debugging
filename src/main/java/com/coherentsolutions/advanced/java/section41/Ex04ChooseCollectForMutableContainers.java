package com.coherentsolutions.advanced.java.section41;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Illustrates choosing collect() when accumulating elements into a mutable container.
 */
public class Ex04ChooseCollectForMutableContainers {

    /**
     * Main method to execute the collect into mutable container example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of strings to collect
        List<String> words = Arrays.asList("Java", "Streams", "are", "powerful");

        // Using collect() to collect words into a list
        List<String> wordList = words.stream()
                .collect(Collectors.toList());

        // Output the result
        System.out.println("Collected Words using collect(): " + wordList);
    }
}
