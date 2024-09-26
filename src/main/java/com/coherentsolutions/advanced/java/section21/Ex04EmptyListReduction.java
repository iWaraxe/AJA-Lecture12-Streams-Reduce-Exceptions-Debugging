package com.coherentsolutions.advanced.java.section21;

import java.util.Collections;
import java.util.List;

/**
 * Demonstrates the result of reduce() method when the list is empty.
 */
public class Ex04EmptyListReduction {

    /**
     * Main method to show reduction on an empty list.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Empty list of integers
        List<Integer> emptyList = Collections.emptyList();

        // Using reduce() to sum the integers
        int sum = emptyList.stream()
                .reduce(0, Integer::sum);

        // Output the result
        System.out.println("Sum of empty list: " + sum);
    }
}
