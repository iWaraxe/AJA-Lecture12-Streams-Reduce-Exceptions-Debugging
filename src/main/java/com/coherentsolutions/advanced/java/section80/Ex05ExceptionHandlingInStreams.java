package com.coherentsolutions.advanced.java.section80;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates exception handling within stream operations.
 * Utilizes a utility method to wrap checked exceptions in unchecked exceptions.
 */
public class Ex05ExceptionHandlingInStreams {

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/products.csv";

        try {
            List<Product> products = Files.lines(Paths.get(filePath))
                    .skip(1) // Skip header line
                    .map(ExceptionUtil.wrap(line -> {
                        String[] fields = line.split(",");
                        return new Product(
                                fields[0],                          // id
                                fields[1],                          // name
                                Double.parseDouble(fields[2]),      // price
                                fields[3],                          // category
                                Boolean.parseBoolean(fields[4])     // inStock
                        );
                    }))
                    .collect(Collectors.toList());

            // Output the loaded products
            products.forEach(System.out::println);
        } catch (RuntimeException e) {
            System.err.println("Error processing file: " + e.getCause().getMessage());
        }
    }
}

/**
 * Utility class for handling checked exceptions in streams.
 */
class ExceptionUtil {
    @FunctionalInterface
    public interface CheckedFunction<T, R> {
        R apply(T t) throws Exception;
    }

    /**
     * Wraps a CheckedFunction to handle checked exceptions within stream operations.
     *
     * @param function The CheckedFunction that may throw an exception.
     * @param <T>      The input type.
     * @param <R>      The return type.
     * @return A function that can be used in stream operations.
     */
    public static <T, R> java.util.function.Function<T, R> wrap(CheckedFunction<T, R> function) {
        return t -> {
            try {
                return function.apply(t);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}