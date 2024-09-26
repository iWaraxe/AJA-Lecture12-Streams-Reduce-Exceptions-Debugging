package com.coherentsolutions.advanced.java.section10.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates issues with non-associative reduction operations in parallel streams.
 */
public class Ex09NonAssociativeReduction {

    /**
     * Main method to execute the non-associative reduction example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of floating-point numbers
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0);

        // Sum the reciprocals using reduce() in a parallel stream
        // The operation is not associative due to floating-point precision
        double sumOfReciprocals = numbers.parallelStream()
                .reduce(0.0, (a, b) -> a + 1 / b);

        // Output the result
        System.out.println("Sum of Reciprocals: " + sumOfReciprocals);
    }
}
