package com.coherentsolutions.advanced.java.section70;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates using the peek() method for logging intermediate results in a stream pipeline.
 */
public class Ex01PeekDebuggingExample {

    /**
     * Main method to execute the peek debugging example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Stream pipeline with peek() for debugging
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("After filter: " + n))
                .map(n -> n * n)
                .peek(n -> System.out.println("After map: " + n))
                .forEach(System.out::println);
    }
}
