package com.coherentsolutions.advanced.java.section30.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates partitioning stream elements into a Map using Collectors.partitioningBy().
 */
public class Ex07PartitioningByExample {

    /**
     * Main method to execute the partitioningBy example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Partition numbers into even and odd using partitioningBy
        Map<Boolean, List<Integer>> partitionedNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        // Output the result
        System.out.println("Even Numbers: " + partitionedNumbers.get(true));
        System.out.println("Odd Numbers: " + partitionedNumbers.get(false));
    }
}
