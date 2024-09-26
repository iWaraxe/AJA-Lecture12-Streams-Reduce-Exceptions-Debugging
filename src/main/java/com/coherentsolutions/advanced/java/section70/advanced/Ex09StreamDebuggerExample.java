package com.coherentsolutions.advanced.java.section70.advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Placeholder class to discuss the use of IDE tools like Stream Debugger.
 * Since we cannot demonstrate an IDE tool in code, this class provides information.
 */
public class Ex09StreamDebuggerExample {

    /**
     * Main method to discuss the Stream Debugger tool.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // List of numbers to process
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Complex stream pipeline
        int result = numbers.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);

        // Output the result
        System.out.println("Result: " + result);

        /**
         * Note:
         * To debug this stream pipeline using an IDE like IntelliJ IDEA:
         * - Set a breakpoint at the start of the main method.
         * - Run the debugger.
         * - Use the "Trace Current Stream Chain" feature to visualize each operation.
         * - This allows you to see the elements at each stage of the pipeline.
         */
    }
}
