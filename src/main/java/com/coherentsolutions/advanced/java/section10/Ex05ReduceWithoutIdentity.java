package com.coherentsolutions.advanced.java.section10.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Demonstrates the use of reduce() without an identity value, returning an Optional.
 */
public class Ex05ReduceWithoutIdentity {

    /**
     * Main method to execute the reduction without identity example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers (could be empty)
        List<Integer> numbers = Arrays.asList();

        // Use reduce() without identity value
        Optional<Integer> result = numbers.stream()
                .reduce((a, b) -> a + b);

        // Check if a value is present
        if (result.isPresent()) {
            System.out.println("Sum: " + result.get());
        } else {
            System.out.println("The list is empty.");
        }
    }
}
