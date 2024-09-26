package com.coherentsolutions.advanced.java.section41.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Compares the performance of reduce() and collect() for accumulating elements into a List.
 */
public class Ex07PerformanceCompareReduceCollect {

    /**
     * Main method to execute the performance comparison.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Generate a large list of integers
        List<Integer> numbers = Arrays.asList(new Integer[100_000]);
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, i + 1);
        }

        // Measure time for reduce()
        long startTime = System.currentTimeMillis();
        List<Integer> listWithReduce = numbers.stream()
                .reduce(
                        new java.util.ArrayList<>(),
                        (list, number) -> {
                            list.add(number);
                            return list;
                        },
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        }
                );
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by reduce(): " + (endTime - startTime) + " ms");

        // Measure time for collect()
        startTime = System.currentTimeMillis();
        List<Integer> listWithCollect = numbers.stream()
                .collect(Collectors.toList());
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by collect(): " + (endTime - startTime) + " ms");
    }
}
