package com.coherentsolutions.advanced.java.section50;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Demonstrates counting the frequency of numbers in a list using collect().
 */
public class Ex04FrequencyMapExample {

    /**
     * Main method to execute the frequency map example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of numbers with duplicates
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);

        // Create a frequency map using collect()
        Map<Integer, Long> frequencyMap = numbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),      // Classifier function to group by the number itself
                        Collectors.counting()      // Downstream collector to count occurrences
                ));

        // Output the result
        System.out.println("Frequency Map: " + frequencyMap);
    }
}
