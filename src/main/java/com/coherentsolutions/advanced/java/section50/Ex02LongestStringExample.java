package com.coherentsolutions.advanced.java.section50;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Demonstrates finding the longest string in a list using reduce().
 */
public class Ex02LongestStringExample {

    /**
     * Main method to execute the longest string example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of strings to evaluate
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        // Find the longest string using reduce()
        Optional<String> longest = strings.stream()
                .reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);

        // Output the result if present
        longest.ifPresent(s -> System.out.println("Longest String: " + s));
    }
}
