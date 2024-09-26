package com.coherentsolutions.advanced.java.section30;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Demonstrates using reduce() to collect elements into a List.
 * This approach is less efficient and more error-prone compared to using collect().
 */
public class Ex01ReduceToListExample {

    /**
     * Main method to execute the reduce to List example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of words
        List<String> words = Arrays.asList("Java", "Streams", "are", "powerful");

        // Attempting to collect words into a list using reduce()
        List<String> wordList = words.stream().reduce(
                new ArrayList<>(),                             // Identity: new empty list
                (List<String> list, String word) -> {          // Accumulator: adds word to list
                    list.add(word);                            // Side-effect: modifying the list
                    return list;                               // Returns the modified list
                },
                (List<String> list1, List<String> list2) -> {  // Combiner: merges two lists
                    list1.addAll(list2);                       // Side-effect: modifying list1
                    return list1;                              // Returns the merged list
                }
        );

        // Output the result
        System.out.println("Words collected using reduce(): " + wordList);
    }
}
