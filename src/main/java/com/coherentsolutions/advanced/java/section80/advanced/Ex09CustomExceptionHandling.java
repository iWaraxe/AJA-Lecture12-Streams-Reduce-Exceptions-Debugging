package com.coherentsolutions.advanced.java.section80.advanced;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates custom exception handling within streams using a custom functional interface.
 */
public class Ex09CustomExceptionHandling {

    public static void main(String[] args) {
        try {
            List<String> results = Stream.of("100", "200", "abc", "300")
                    .map(ThrowingFunction.wrapper(Integer::parseInt))
                    .map(i -> "Number: " + i)
                    .collect(Collectors.toList());

            results.forEach(System.out::println);
        } catch (RuntimeException e) {
            System.err.println("Error parsing number: " + e.getCause().getMessage());
        }
    }
}

/**
 * Utility class for handling checked exceptions in streams.
 */
class ThrowingFunction {

    @FunctionalInterface
    public interface CheckedFunction<T, R> {
        R apply(T t) throws Exception;
    }

    /**
     * Wraps a CheckedFunction to handle exceptions within stream operations.
     *
     * @param function The CheckedFunction.
     * @param <T>      Input type.
     * @param <R>      Return type.
     * @return A function that wraps exceptions in RuntimeException.
     */
    public static <T, R> java.util.function.Function<T, R> wrapper(CheckedFunction<T, R> function) {
        return t -> {
            try {
                return function.apply(t);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}
