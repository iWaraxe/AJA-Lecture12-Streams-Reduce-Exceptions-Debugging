package com.coherentsolutions.advanced.java.section60;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Demonstrates wrapping checked exceptions in unchecked exceptions within streams.
 * This allows us to handle checked exceptions like IOException in lambda expressions.
 */
public class Ex02WrappingExceptionsExample {

    /**
     * Main method to execute the wrapping exceptions example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of file paths to read
        List<String> filePaths = List.of("file1.txt", "file2.txt", "file3.txt");

        // Using stream and wrapping IOException in RuntimeException
        List<String> fileContents = filePaths.stream()
                .map(path -> {
                    try {
                        // Attempt to read the file content
                        return Files.readString(Paths.get(path));
                    } catch (IOException e) {
                        // Wrap IOException in an unchecked RuntimeException
                        throw new RuntimeException("Error reading file: " + path, e);
                    }
                })
                .toList();

        // Output the contents
        fileContents.forEach(System.out::println);
    }
}
