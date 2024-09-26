package com.coherentsolutions.advanced.java.section60;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;

/**
 * Demonstrates using a utility method to handle checked exceptions in streams.
 * This approach abstracts exception handling, improving code readability and reusability.
 */
public class Ex04UtilityMethodExample {

    /**
     * Main method to execute the utility method example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of file paths, including a nonexistent file to trigger an exception
        List<String> filePaths = List.of("file1.txt", "nonexistent.txt", "file3.txt");

        // Using the utility method to handle exceptions
        List<String> fileContents = filePaths.stream()
                .map(handleException(path -> Files.readString(Paths.get(path))))
                .toList();

        // Output the contents
        fileContents.forEach(System.out::println);
    }

    /**
     * Utility method to handle checked exceptions in lambda expressions.
     *
     * @param function A CheckedFunction that may throw an exception.
     * @param <T>      The input type.
     * @param <R>      The return type.
     * @return A Function that wraps the CheckedFunction and handles exceptions.
     */
    public static <T, R> Function<T, R> handleException(CheckedFunction<T, R> function) {
        return arg -> {
            try {
                // Attempt to apply the function
                return function.apply(arg);
            } catch (Exception e) {
                // Log the error and return null or an empty value instead of halting the process
                System.err.println("Error processing: " + arg + " - " + e.getMessage());
                return null; // or return an empty string "" if more suitable
            }
        };
    }

    /**
     * Functional interface that allows for checked exceptions.
     *
     * @param <T> The input type.
     * @param <R> The return type.
     */
    @FunctionalInterface
    interface CheckedFunction<T, R> {
        R apply(T t) throws Exception;
    }
}
