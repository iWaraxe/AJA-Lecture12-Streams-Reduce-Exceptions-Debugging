package com.coherentsolutions.advanced.java.section60;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Demonstrates the problem with checked exceptions in Java Streams.
 * Shows that checked exceptions cannot be thrown directly in lambda expressions used in streams.
 */
public class Ex01ExceptionInStreamsExample {

    /**
     * Main method to demonstrate the issue with checked exceptions in streams.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of file paths to read
        List<String> filePaths = List.of("file1.txt", "file2.txt", "file3.txt");

        // Attempting to read files using stream (This will cause a compile-time error)
        // Uncommenting the following code will result in a compilation error
        /*
        List<String> fileContents = filePaths.stream()
                .map(path -> Files.readString(Paths.get(path))) // Compile-time error: unhandled IOException
                .toList();

        // Output the contents
        fileContents.forEach(System.out::println);
        */

        // Explanation
        System.out.println("This code will not compile because Files.readString() throws a checked IOException, " +
                "which cannot be thrown in a lambda expression used in the stream without handling it.");
    }
}
