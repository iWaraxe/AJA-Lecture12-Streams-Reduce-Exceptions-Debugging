package com.coherentsolutions.advanced.java.section70.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Demonstrates using a logging framework within stream operations for debugging.
 */
public class Ex07LoggingInStreams {

    // Create a Logger instance
    private static final Logger logger = Logger.getLogger(Ex07LoggingInStreams.class.getName());

    /**
     * Main method to execute the logging in streams example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of names to process
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");

        // Stream pipeline with logging
        names.stream()
                .filter(name -> {
                    boolean isShortName = name.length() <= 4;
                    logger.info("Filtering " + name + ": " + isShortName);
                    return isShortName;
                })
                .map(String::toUpperCase)
                .forEach(name -> logger.info("Processing name: " + name));
    }
}
