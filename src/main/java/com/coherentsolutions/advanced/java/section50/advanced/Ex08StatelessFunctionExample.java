package com.coherentsolutions.advanced.java.section50.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the importance of using stateless and side-effect-free functions in streams.
 */
public class Ex08StatelessFunctionExample {

    /**
     * Main method to execute the stateless function example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words
        List<String> words = Arrays.asList("one", "two", "three", "four", "five");

        // Counter to demonstrate side effects (not recommended)
        int[] counter = {0};

        // Incorrect usage: function with side effects
        words.parallelStream().forEach(word -> {
            counter[0]++;
            System.out.println("Processing word: " + word);
        });

        // Output the counter value
        System.out.println("Total words processed: " + counter[0]);
    }
}
