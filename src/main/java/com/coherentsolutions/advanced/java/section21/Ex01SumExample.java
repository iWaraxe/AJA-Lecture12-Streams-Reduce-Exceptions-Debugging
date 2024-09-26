package com.coherentsolutions.advanced.java.section21;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the use of reduce() method with identity and accumulator to sum integers.
 */
public class Ex01SumExample {

    /**
     * Main method to execute the sum example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using reduce() to sum the integers with a lambda expression
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        // Alternatively, using method reference
        int sumMethodRef = numbers.stream()
                .reduce(0, Integer::sum);

        // Output the results
        System.out.println("Sum using lambda: " + sum);
        System.out.println("Sum using method reference: " + sumMethodRef);
    }
}
