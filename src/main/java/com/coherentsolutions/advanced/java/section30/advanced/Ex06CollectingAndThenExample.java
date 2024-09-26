package com.coherentsolutions.advanced.java.section30.advanced;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Demonstrates using Collectors.collectingAndThen() to transform the result after collection.
 */
public class Ex06CollectingAndThenExample {

    /**
     * Main method to execute the collectingAndThen example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of names
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Bob");

        // Collect unique names into an unmodifiable set
        Set<String> uniqueNames = names.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toSet(),          // First collect into a Set
                        Collections::unmodifiableSet // Then make the Set unmodifiable
                ));

        // Output the result
        System.out.println("Unique Names (Unmodifiable): " + uniqueNames);

        // Attempting to modify the set will throw an exception
        // uniqueNames.add("David"); // This will throw UnsupportedOperationException
    }
}
