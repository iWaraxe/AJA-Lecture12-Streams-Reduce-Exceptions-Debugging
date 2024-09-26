package com.coherentsolutions.advanced.java.section60.advanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates collecting exceptions during stream processing.
 * Instead of stopping the stream, we collect exceptions and process them after the stream completes.
 */
public class Ex06CollectingExceptionsExample {

    /**
     * Main method to execute the collecting exceptions example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of file paths, including some that may not exist
        List<String> filePaths = List.of("file1.txt", "nonexistent.txt", "file2.txt", "invalid.txt");

        // List to collect exceptions
        List<Exception> exceptions = new ArrayList<>();

        // Process the files and collect exceptions
        List<String> fileContents = filePaths.stream()
                .map(path -> {
                    try {
                        // Attempt to read the file content
                        return Files.readString(Paths.get(path));
                    } catch (IOException e) {
                        // Collect the exception
                        exceptions.add(new Exception("Error reading file: " + path, e));
                        // Return a default value
                        return "";
                    }
                })
                .toList();

        // Output the contents
        fileContents.forEach(System.out::println);

        // After processing, handle the collected exceptions
        if (!exceptions.isEmpty()) {
            System.err.println("The following exceptions occurred during stream processing:");
            exceptions.forEach(ex -> System.err.println(ex.getMessage()));
        }
    }
}
