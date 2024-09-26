package com.coherentsolutions.advanced.java.section42;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates using the count() method for efficient counting of stream elements.
 * Using count() is more efficient and readable compared to using reduce() for counting.
 */
public class Ex04ChooseCountOverReduce {

    /**
     * Main method to execute the count example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of elements to count
        List<String> elements = Arrays.asList("a", "b", "c", "d");

        // Using count() method (efficient)
        long count = elements.stream().count();

        // Output the result
        System.out.println("Count of elements: " + count);
    }
}
