package com.coherentsolutions.advanced.java.section43.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates using parallel streams with proper collectors to ensure thread safety and performance.
 * Proper use of collect() ensures that mutable reductions are handled correctly in parallel streams.
 */
public class Ex09UsingParallelStreamsWithProperCollectors {

    /**
     * Main method to execute the parallel streams with proper collectors example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Large list of words to collect
        List<String> words = Arrays.asList(new String[10_000_000]);
        Arrays.fill(words.toArray(), "word");

        // Using parallel stream with collect()
        long startTime = System.currentTimeMillis();
        List<String> collectedWords = words.parallelStream()
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Collected " + collectedWords.size() + " words using parallel collect(), Time taken: " +
                (endTime - startTime) + " ms");
    }
}
