package com.coherentsolutions.advanced.java.section60;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Demonstrates using a custom functional interface to handle checked exceptions in streams.
 * This provides a structured way to manage exceptions without wrapping them in unchecked exceptions.
 */
public class Ex05CustomInterfaceExample {

    /**
     * Main method to execute the custom functional interface example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of file paths, including a nonexistent file to trigger an exception
        List<String> filePaths = List.of("file1.txt", "nonexistent.txt", "file3.txt");

        try {
            // Using the custom interface with a method that throws IOException
            List<String> fileContents = filePaths.stream()
                    .map(ThrowingFunction.wrapper(path -> Files.readString(Paths.get(path))))
                    .toList();

            // Output the contents
            fileContents.forEach(System.out::println);
        } catch (RuntimeException e) {
            // Handle the RuntimeException wrapping the IOException
            System.err.println("An error occurred: " + e.getCause().getMessage());
        }
    }

    /**
     * Custom functional interface that allows for checked exceptions.
     *
     * @param <T> Input type.
     * @param <R> Return type.
     * @param <E> Exception type that extends Exception.
     */
    @FunctionalInterface
    interface ThrowingFunction<T, R, E extends Exception> {
        R apply(T t) throws E;

        /**
         * Wrapper method to convert a ThrowingFunction into a standard Function.
         * Wraps any thrown exception into a RuntimeException.
         *
         * @param throwingFunction The ThrowingFunction to wrap.
         * @param <T>              Input type.
         * @param <R>              Return type.
         * @param <E>              Exception type that extends Exception.
         * @return A standard Function that can be used in streams.
         */
        static <T, R, E extends Exception> java.util.function.Function<T, R> wrapper(ThrowingFunction<T, R, E> throwingFunction) {
            return input -> {
                try {
                    // Attempt to apply the function
                    return throwingFunction.apply(input);
                } catch (Exception e) {
                    // Wrap the exception in a RuntimeException
                    throw new RuntimeException("Exception occurred during stream processing", e);
                }
            };
        }
    }
}
