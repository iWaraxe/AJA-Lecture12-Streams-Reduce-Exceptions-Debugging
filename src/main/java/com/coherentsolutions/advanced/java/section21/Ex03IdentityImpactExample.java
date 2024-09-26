package com.coherentsolutions.advanced.java.section21;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the impact of changing the identity value in reduce() method.
 */
public class Ex03IdentityImpactExample {

    /**
     * Main method to show how changing the identity affects the result.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        // Using reduce() with identity 0
        int sumWithZeroIdentity = numbers.stream()
                .reduce(0, Integer::sum);

        // Using reduce() with identity 10
        int sumWithTenIdentity = numbers.stream()
                .reduce(10, Integer::sum);

        // Output the results
        System.out.println("Sum with identity 0: " + sumWithZeroIdentity);
        System.out.println("Sum with identity 10: " + sumWithTenIdentity);
    }
}
