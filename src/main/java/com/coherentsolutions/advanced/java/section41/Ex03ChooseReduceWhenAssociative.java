package com.coherentsolutions.advanced.java.section41;

import java.util.Arrays;
import java.util.List;

/**
 * Illustrates choosing reduce() when the operation is associative and the result is immutable.
 */
public class Ex03ChooseReduceWhenAssociative {

    /**
     * Main method to execute the associative reduce example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers for summation
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Using reduce() to calculate the sum
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        // Output the result
        System.out.println("Sum of numbers using reduce(): " + sum);
    }
}
