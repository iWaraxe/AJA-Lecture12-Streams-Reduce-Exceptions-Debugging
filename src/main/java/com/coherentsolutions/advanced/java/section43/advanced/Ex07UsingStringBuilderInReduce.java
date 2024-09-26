package com.coherentsolutions.advanced.java.section43.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates using StringBuilder within reduce() to optimize string concatenation.
 * Although this approach can improve performance over simple string concatenation,
 * it is still less efficient and less readable compared to using collect().
 */
public class Ex07UsingStringBuilderInReduce {

    /**
     * Main method to execute the StringBuilder in reduce() example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words to concatenate
        List<String> words = Arrays.asList("Java", "Streams", "are", "powerful");

        // Using reduce() with StringBuilder
        StringBuilder sentenceBuilder = words.stream()
                .reduce(new StringBuilder(),
                        (sb, word) -> sb.append(" ").append(word),
                        (sb1, sb2) -> sb1.append(sb2));

        // Now that reduction is done, you can trim the size
        sentenceBuilder.trimToSize();

        String sentence = sentenceBuilder.toString();

        // Output the result
        System.out.println("Concatenated Sentence using reduce() with StringBuilder: " + sentence);
    }
}
