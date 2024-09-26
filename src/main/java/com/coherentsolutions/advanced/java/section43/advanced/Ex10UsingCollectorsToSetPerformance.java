package com.coherentsolutions.advanced.java.section43.advanced;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Compares the performance of using reduce() vs. collect() for accumulating elements into a Set.
 * Highlights the efficiency and simplicity of using collect() with Collectors.toSet().
 */
public class Ex10UsingCollectorsToSetPerformance {

    /**
     * Main method to execute the Set accumulation performance comparison.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Generate a large list with duplicate elements
        List<String> words = Arrays.asList(new String[1_000_000]);
        Arrays.fill(words.toArray(), "word");

        // Measure performance of reduce() for collecting into a Set (inefficient)
        long startTime = System.currentTimeMillis();
        Set<String> setWithReduce = words.stream()
                .reduce(new HashSet<>(),
                        (set, word) -> {
                            set.add(word);
                            return set;
                        },
                        (set1, set2) -> {
                            set1.addAll(set2);
                            return set1;
                        });
        long endTime = System.currentTimeMillis();
        System.out.println("Set size using reduce(): " + setWithReduce.size() +
                ", Time taken: " + (endTime - startTime) + " ms");

        // Measure performance of collect() for collecting into a Set (efficient)
        startTime = System.currentTimeMillis();
        Set<String> setWithCollect = words.stream()
                .collect(Collectors.toSet());
        endTime = System.currentTimeMillis();
        System.out.println("Set size using collect(): " + setWithCollect.size() +
                ", Time taken: " + (endTime - startTime) + " ms");
    }
}
