package com.coherentsolutions.advanced.java.section41;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates the use of collect() method to collect even numbers into a List.
 */
public class Ex02CollectEvenNumbersExample {

    /**
     * Main method to execute the collect even numbers example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Using collect() to collect even numbers into a list
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        // Output the result
        System.out.println("Even numbers: " + evenNumbers);
    }
}
