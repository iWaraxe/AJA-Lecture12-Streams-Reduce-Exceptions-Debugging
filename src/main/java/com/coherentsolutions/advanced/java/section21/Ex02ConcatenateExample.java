package com.coherentsolutions.advanced.java.section21;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the use of reduce() method with identity and accumulator to concatenate strings.
 */
public class Ex02ConcatenateExample {

    /**
     * Main method to execute the string concatenation example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words
        List<String> words = Arrays.asList("Java", "Streams", "are", "powerful");

        // Using reduce() to concatenate strings
        String sentence = words.stream()
                .reduce("", (s1, s2) -> s1 + " " + s2).trim();

        // Output the result
        System.out.println("Concatenated Sentence: " + sentence);
    }
}
