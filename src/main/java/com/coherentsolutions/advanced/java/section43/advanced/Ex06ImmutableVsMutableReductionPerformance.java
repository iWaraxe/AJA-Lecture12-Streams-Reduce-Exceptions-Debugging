package com.coherentsolutions.advanced.java.section43.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Compares the performance impact of immutable vs. mutable reductions.
 * Shows how mutable reductions using collect() can be more efficient than immutable reductions using reduce().
 */
public class Ex06ImmutableVsMutableReductionPerformance {

    /**
     * Main method to execute the performance comparison.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Generate a large list of words
        List<String> words = Arrays.asList(new String[1_000_000]);
        Arrays.fill(words.toArray(), "word");

        // Measure performance of immutable reduction using reduce()
        long startTime = System.currentTimeMillis();
        String sentenceWithReduce = words.stream()
                .reduce("", (partialString, word) -> partialString + " " + word)
                .trim();
        long endTime = System.currentTimeMillis();
        System.out.println("Concatenated Sentence using reduce() Length: " + sentenceWithReduce.length() +
                ", Time taken: " + (endTime - startTime) + " ms");

        // Measure performance of mutable reduction using collect()
        startTime = System.currentTimeMillis();
        String sentenceWithCollect = words.stream()
                .collect(Collectors.joining(" "));
        endTime = System.currentTimeMillis();
        System.out.println("Concatenated Sentence using collect() Length: " + sentenceWithCollect.length() +
                ", Time taken: " + (endTime - startTime) + " ms");
    }
}
