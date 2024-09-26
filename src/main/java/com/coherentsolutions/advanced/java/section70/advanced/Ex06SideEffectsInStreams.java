package com.coherentsolutions.advanced.java.section70.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Demonstrates the issues that can arise when using side effects in stream operations.
 * Shows why side effects should be avoided in functional programming.
 */
public class Ex06SideEffectsInStreams {

    /**
     * Main method to execute the side effects in streams example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers to process
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Shared mutable list to collect even numbers (not recommended)
        List<Integer> evenNumbers = new ArrayList<>();

        // Using forEach with side effects (modifying external state)
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(evenNumbers::add); // Side effect: modifying external list

        // Output the collected even numbers
        System.out.println("Even numbers collected using side effects: " + evenNumbers);

        // Recommended approach without side effects
        List<Integer> evenNumbersCollected = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList(); // Collecting results without side effects

        // Output the collected even numbers
        System.out.println("Even numbers collected without side effects: " + evenNumbersCollected);
    }
}
