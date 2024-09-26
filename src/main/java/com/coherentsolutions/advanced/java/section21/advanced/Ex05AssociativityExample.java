package com.coherentsolutions.advanced.java.section21.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the importance of associativity in the accumulator function.
 */
public class Ex05AssociativityExample {

    /**
     * Main method to demonstrate non-associative accumulator impact.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(2, 4, 8);

        // Accumulator function that is non-associative
        int result = numbers.stream()
                .reduce(1, (a, b) -> (a + b) / 2);

        // Output the result
        System.out.println("Result with non-associative accumulator: " + result);
    }
}
