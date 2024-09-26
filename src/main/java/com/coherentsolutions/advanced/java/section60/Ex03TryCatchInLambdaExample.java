package com.coherentsolutions.advanced.java.section60;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Demonstrates handling exceptions directly within lambda expressions in streams.
 * This allows us to manage exceptions like IOException without disrupting the stream pipeline.
 */
public class Ex03TryCatchInLambdaExample {

    /**
     * Main method to execute the try-catch within lambda example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of file paths, including a nonexistent file to trigger an exception
        List<String> filePaths = List.of("file1.txt", "nonexistent.txt", "file3.txt");

        // Handling exceptions inside the lambda expression
        List<String> fileContents = filePaths.stream()
                .map(path -> {
                    try {
                        // Attempt to read the file content
                        return Files.readString(Paths.get(path));
                    } catch (IOException e) {
                        // Handle the exception (e.g., log the error and return a default value)
                        System.err.println("Error reading file: " + path + " - " + e.getMessage());
                        return ""; // Return an empty string as a default value
                    }
                })
                .toList();

        // Output the contents
        fileContents.forEach(System.out::println);
    }
}
