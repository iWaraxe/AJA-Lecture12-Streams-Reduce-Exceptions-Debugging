package com.coherentsolutions.advanced.java.section50;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates concatenating a list of strings with commas using reduce().
 */
public class Ex03StringConcatenationExample {

    /**
     * Main method to execute the string concatenation example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of programming languages
        List<String> strings = Arrays.asList("Java", "Python", "C++", "JavaScript");

        // Concatenate strings with commas using reduce()
        String concatenated = strings.stream()
                .reduce("", (s1, s2) -> s1.isEmpty() ? s2 : s1 + ", " + s2);

        // Output the result
        System.out.println("Concatenated String: " + concatenated);
    }
}
