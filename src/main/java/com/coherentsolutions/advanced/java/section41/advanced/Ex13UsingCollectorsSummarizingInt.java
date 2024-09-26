package com.coherentsolutions.advanced.java.section41.advanced;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates using Collectors.summarizingInt() to get a statistical summary of integers.
 */
public class Ex13UsingCollectorsSummarizingInt {

    /**
     * Main method to execute the summarizingInt collector example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of numbers
        List<Integer> numbers = Arrays.asList(3, 5, 7, 9, 11);

        // Get statistical summary of the numbers
        IntSummaryStatistics stats = numbers.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        // Output the result
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());
    }
}
