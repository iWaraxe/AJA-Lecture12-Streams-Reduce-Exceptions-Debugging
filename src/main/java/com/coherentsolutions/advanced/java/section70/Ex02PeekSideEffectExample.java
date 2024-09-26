package com.coherentsolutions.advanced.java.section70;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the limitations of using peek() to modify elements in a stream.
 * Shows why modifying elements in peek() can lead to side effects and unpredictable results.
 */
public class Ex02PeekSideEffectExample {

    /**
     * Main method to execute the peek side effect example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of mutable StringBuilder objects
        List<StringBuilder> names = Arrays.asList(
                new StringBuilder("Alice"),
                new StringBuilder("Bob"),
                new StringBuilder("Charlie")
        );

        // Incorrect use of peek() to modify elements
        names.stream()
                .peek(name -> name.append(" Smith")) // Modifying elements in peek() (side effects)
                .forEach(name -> System.out.println(name));
    }
}
