package com.coherentsolutions.advanced.java.section80;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates performance optimization using parallel streams.
 * Compares sequential and parallel processing of a large dataset.
 */
public class Ex06ParallelStreamsPerformance {

    public static void main(String[] args) {
        // Generate a large list of random products
        List<Product> products = Stream.generate(Ex06ParallelStreamsPerformance::generateRandomProduct)
                .limit(1_000_000)
                .collect(Collectors.toList());

        // Sequential processing
        long startTime = System.currentTimeMillis();
        double totalPriceSequential = products.stream()
                .filter(Product::isInStock)
                .mapToDouble(Product::getPrice)
                .sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential processing time: " + (endTime - startTime) + " ms");
        System.out.println("Total price (sequential): $" + totalPriceSequential);

        // Parallel processing
        startTime = System.currentTimeMillis();
        double totalPriceParallel = products.parallelStream()
                .filter(Product::isInStock)
                .mapToDouble(Product::getPrice)
                .sum();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel processing time: " + (endTime - startTime) + " ms");
        System.out.println("Total price (parallel): $" + totalPriceParallel);
    }

    /**
     * Generates a random product for simulation purposes.
     *
     * @return A randomly generated Product object.
     */
    public static Product generateRandomProduct() {
        String id = String.valueOf(ThreadLocalRandom.current().nextInt(1, 1_000_000));
        String name = "Product" + id;
        double price = ThreadLocalRandom.current().nextDouble(1.00, 1000.00);
        String category = "Category" + ThreadLocalRandom.current().nextInt(1, 10);
        boolean inStock = ThreadLocalRandom.current().nextBoolean();

        return new Product(id, name, price, category, inStock);
    }
}