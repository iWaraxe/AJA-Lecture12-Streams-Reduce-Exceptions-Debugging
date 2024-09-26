package com.coherentsolutions.advanced.java.section43.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Demonstrates creating and using a custom collector for string concatenation.
 * Custom collectors can offer more control and potentially better performance
 * for specific accumulation tasks.
 */
public class Ex08UsingCustomCollector {

    /**
     * Main method to execute the custom collector example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words to concatenate
        List<String> words = Arrays.asList("Java", "Streams", "are", "powerful");

        // Create a custom collector for concatenating strings with spaces
        String sentence = words.stream()
                .collect(Collector.of(
                        StringBuilder::new,                           // Supplier: creates a new StringBuilder
                        (sb, word) -> sb.append(word).append(" "),    // Accumulator: appends word and space
                        (sb1, sb2) -> sb1.append(sb2),                // Combiner: merges two StringBuilders
                        sb -> sb.toString().trim()                    // Finisher: converts to String and trims
                ));

        // Output the result
        System.out.println("Concatenated Sentence using custom collector: " + sentence);
    }
}
