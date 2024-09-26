package com.coherentsolutions.advanced.java.section42.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Demonstrates using Collectors.reducing() to perform a reduction operation with a collector.
 * Collectors.reducing() provides a way to perform custom reduction operations during collection.
 */
public class Ex16UsingCollectorsReducing {

    /**
     * Main method to execute the reducing collector example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Use reducing collector to compute the product of all numbers
        Optional<Integer> product = numbers.stream()
                .collect(Collectors.reducing((a, b) -> a * b));

        // Output the result
        product.ifPresent(result -> System.out.println("Product of numbers: " + result));
    }
}
