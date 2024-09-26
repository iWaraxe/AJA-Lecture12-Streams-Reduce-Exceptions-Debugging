package com.coherentsolutions.advanced.java.section50.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Demonstrates handling null elements in a stream.
 */
public class Ex06NullElementsHandling {

    /**
     * Main method to execute the null elements handling example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of strings with a null element
        List<String> strings = Arrays.asList("apple", null, "banana", "cherry", null);

        // Filter out null elements and concatenate remaining strings
        String concatenated = strings.stream()
                .filter(Objects::nonNull)  // Filters out null elements
                .reduce("", (s1, s2) -> s1.isEmpty() ? s2 : s1 + ", " + s2);

        // Output the result
        System.out.println("Concatenated String (without nulls): " + concatenated);
    }
}
