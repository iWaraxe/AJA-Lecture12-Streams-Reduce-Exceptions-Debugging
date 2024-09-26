package com.coherentsolutions.advanced.java.section80.advanced;

import com.coherentsolutions.advanced.java.section80.Product;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates simulating a live data stream using an infinite stream.
 * Generates random products and processes them using stream operations.
 */
public class Ex08InfiniteStreamSimulation {

    public static void main(String[] args) {
        // Simulate a live stream of products
        List<Product> products = Stream.generate(ProductSimulator::generateRandomProduct)
                .limit(1000) // Limit the stream to 1000 products
                .filter(product -> product.getPrice() > 0)         // Data cleaning
                .filter(product -> product.getName() != null)
                .map(product -> {
                    // Data transformation
                    product.setName(product.getName().toUpperCase());
                    return product;
                })
                .collect(Collectors.toList());

        // Output the number of products processed
        System.out.println("Number of products processed: " + products.size());
    }
}

/**
 * Simulates generating random Product objects.
 */
class ProductSimulator {

    /**
     * Generates a random product.
     *
     * @return A randomly generated Product object.
     */
    public static Product generateRandomProduct() {
        // Implementation similar to Ex06ParallelStreamsPerformance
        // (Omitted for brevity)
        return new Product("id", "name", 100.0, "category", true);
    }
}