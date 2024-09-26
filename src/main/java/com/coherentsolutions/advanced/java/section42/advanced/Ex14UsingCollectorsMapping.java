package com.coherentsolutions.advanced.java.section42.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Demonstrates using Collectors.mapping() to apply a mapping function during collection.
 * Collectors.mapping() allows you to transform elements while collecting them into a collection.
 */
public class Ex14UsingCollectorsMapping {

    /**
     * Main method to execute the mapping collector example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of names
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Collect the lengths of names into a Set
        Set<Integer> nameLengths = names.stream()
                .collect(Collectors.mapping(
                        String::length,            // Mapping function to get length of each name
                        Collectors.toSet()         // Downstream collector to collect into a Set
                ));

        // Output the result
        System.out.println("Lengths of Names: " + nameLengths);
    }
}
