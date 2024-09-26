package com.coherentsolutions.advanced.java.section50.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Demonstrates handling empty streams when using reduce().
 */
public class Ex05EmptyStreamHandling {

    /**
     * Main method to execute the empty stream handling example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Empty list of integers
        List<Integer> numbers = new ArrayList<>();

        // Attempt to find the maximum number using reduce()
        Optional<Integer> max = numbers.stream()
                .reduce(Integer::max);

        // Check if a value is present and output the result
        if (max.isPresent()) {
            System.out.println("Maximum number: " + max.get());
        } else {
            System.out.println("Stream is empty. No maximum number found.");
        }
    }
}
