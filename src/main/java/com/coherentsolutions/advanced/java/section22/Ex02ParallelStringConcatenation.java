package com.coherentsolutions.advanced.java.section22;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the use of reduce() with identity, accumulator, and combiner
 * in a parallel stream to concatenate strings.
 */
public class Ex02ParallelStringConcatenation {

    /**
     * Main method to execute the parallel string concatenation example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words to concatenate
        List<String> words = Arrays.asList("Java", "Streams", "are", "powerful");

        // Using reduce() with identity, accumulator, and combiner in a parallel stream
        String sentence = words.parallelStream()
                .reduce("",
                        (partialString, word) -> {
                            // Accumulator: combines partial string with the next word
                            return partialString + " " + word;
                        },
                        (s1, s2) -> {
                            // Combiner: combines two partial strings
                            return s1 + s2;
                        }).trim(); // Remove any leading/trailing whitespace

        // Output the result
        System.out.println("Concatenated Sentence: " + sentence);
    }
}
