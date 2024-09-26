package com.coherentsolutions.advanced.java.section41.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates using Collectors.partitioningBy() to partition elements based on a predicate.
 */
public class Ex11UsingCollectorsPartitioningBy {

    /**
     * Main method to execute the partitioningBy collector example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Partition numbers into even and odd
        Map<Boolean, List<Integer>> partitionedNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        // Output the result
        System.out.println("Even Numbers: " + partitionedNumbers.get(true));
        System.out.println("Odd Numbers: " + partitionedNumbers.get(false));
    }
}
