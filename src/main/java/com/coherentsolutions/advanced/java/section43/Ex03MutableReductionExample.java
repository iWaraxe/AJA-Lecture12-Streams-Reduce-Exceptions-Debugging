package com.coherentsolutions.advanced.java.section43;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates mutable reduction using the collect() method to concatenate strings.
 * This approach uses a single StringBuilder internally, making it more efficient
 * compared to immutable reduction with reduce().
 */
public class Ex03MutableReductionExample {

    /**
     * Main method to execute the mutable reduction example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words to concatenate
        List<String> words = Arrays.asList("Java", "Streams", "are", "powerful");

        // Concatenate words using collect() (mutable reduction)
        String sentence = words.stream()
                .collect(Collectors.joining(" "));

        // Output the result
        System.out.println("Concatenated Sentence using collect(): " + sentence);
    }
}
