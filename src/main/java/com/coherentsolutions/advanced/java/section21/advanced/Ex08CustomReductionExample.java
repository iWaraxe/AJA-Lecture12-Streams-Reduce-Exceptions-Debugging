package com.coherentsolutions.advanced.java.section21.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Demonstrates the use of reduce() without an identity value.
 */
public class Ex08CustomReductionExample {

    /**
     * Main method to execute reduction without identity.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(5, 10, 15);

        // Using reduce() without identity
        Optional<Integer> product = numbers.stream()
                .reduce((a, b) -> a * b);

        // Check if a value is present
        if (product.isPresent()) {
            System.out.println("Product of numbers: " + product.get());
        } else {
            System.out.println("List is empty.");
        }
    }
}
