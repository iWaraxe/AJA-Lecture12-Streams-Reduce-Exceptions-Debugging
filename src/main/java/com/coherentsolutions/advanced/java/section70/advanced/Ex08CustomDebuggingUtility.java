package com.coherentsolutions.advanced.java.section70.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Demonstrates creating a custom debugging utility for stream pipelines.
 */
public class Ex08CustomDebuggingUtility {

    /**
     * Main method to execute the custom debugging utility example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of numbers to process
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Stream pipeline using custom debug method
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(debug(n -> n * n, "After squaring"))
                .forEach(System.out::println);
    }

    /**
     * Custom debug method that logs the result of a function application.
     *
     * @param function The function to apply.
     * @param message  The debug message to display.
     * @param <T>      The input type.
     * @param <R>      The return type.
     * @return A function that applies the original function and logs the result.
     */
    public static <T, R> Function<T, R> debug(Function<T, R> function, String message) {
        return t -> {
            R result = function.apply(t);
            System.out.println(message + ": " + result);
            return result;
        };
    }
}
