package com.coherentsolutions.advanced.java.section10;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the use of the reduce() method to sum a list of integers.
 */
public class Ex01ReductionExample {

    /**
     * Main method to execute the sum reduction example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of integers
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Sum the numbers using reduce()
        int totalSum = numbers.stream()
                .reduce(0, (sum, number) -> sum + number);

        // Output the result
        System.out.println("Total Sum: " + totalSum);
    }
}
