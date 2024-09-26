package com.coherentsolutions.advanced.java.section70;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates writing test cases for individual stream operations using JUnit.
 */
public class Ex03StreamTest {

    /**
     * Tests the filter operation to select even numbers.
     */
    @Test
    public void testFilterEvenNumbers() {
        // List of numbers to filter
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        // Assert that the filtered list contains only even numbers
        assertEquals(Arrays.asList(2, 4), evenNumbers);
    }

    /**
     * Tests the map operation to square numbers.
     */
    @Test
    public void testSquareNumbers() {
        // List of numbers to square
        List<Integer> numbers = Arrays.asList(2, 4);

        // Square each number
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .toList();

        // Assert that the squared numbers are as expected
        assertEquals(Arrays.asList(4, 16), squaredNumbers);
    }
}
