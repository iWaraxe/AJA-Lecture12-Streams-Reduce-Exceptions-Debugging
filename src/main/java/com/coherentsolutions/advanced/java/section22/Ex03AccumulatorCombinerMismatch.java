package com.coherentsolutions.advanced.java.section22;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates issues when accumulator and combiner functions are not compatible.
 */
public class Ex03AccumulatorCombinerMismatch {

    /**
     * Main method to show the impact of incompatible accumulator and combiner.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of strings to concatenate
        List<String> words = Arrays.asList("Hello", "World", "from", "Java");

        // Using reduce() with incompatible accumulator and combiner in a parallel stream
        String result = words.parallelStream()
                .reduce("",
                        (partialString, word) -> {
                            // Accumulator: adds word and a space to the partial string
                            return partialString + word + " ";
                        },
                        (s1, s2) -> {
                            // Combiner: concatenates two partial strings without adding extra space
                            return s1 + s2;
                        });

        // Output the result
        System.out.println("Resulting String: '" + result + "'");
    }
}
