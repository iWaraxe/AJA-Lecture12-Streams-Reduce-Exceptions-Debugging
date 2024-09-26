package com.coherentsolutions.advanced.java.section80;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Demonstrates implementing a custom collector to aggregate product statistics by category.
 */
public class Ex04CustomCollectorExample {

    public static void main(String[] args) {
        // Sample list of products
        List<Product> products = Arrays.asList(
                new Product("1", "LAPTOP", 1200.00, "Electronics", true),
                new Product("2", "SMARTPHONE", 500.00, "Electronics", true),
                new Product("3", "REFRIGERATOR", 800.00, "Appliances", false),
                new Product("4", "TOASTER", 25.00, "Appliances", true),
                new Product("5", "HEADPHONES", 150.00, "Electronics", true)
        );

        // Use the custom collector to aggregate statistics by category
        Map<String, CategoryStats> categoryStatsMap = products.stream()
                .collect(categoryStatisticsCollector());

        // Output the statistics per category
        categoryStatsMap.forEach((category, stats) -> {
            System.out.println("Category: " + category);
            System.out.println(stats);
            System.out.println();
        });
    }

    /**
     * Custom collector to aggregate product statistics by category.
     *
     * @return A collector that produces a Map<String, CategoryStats>.
     */
    public static Collector<Product, ?, Map<String, CategoryStats>> categoryStatisticsCollector() {
        return Collector.of(
                HashMap::new, // Supplier: creates a new HashMap
                (map, product) -> {
                    // Accumulator: updates the CategoryStats for each product
                    map.compute(product.getCategory(), (category, stats) -> {
                        if (stats == null) {
                            stats = new CategoryStats();
                        }
                        stats.addProduct(product);
                        return stats;
                    });
                },
                (map1, map2) -> {
                    // Combiner: merges two maps
                    map2.forEach((category, stats) ->
                            map1.merge(category, stats, CategoryStats::merge));
                    return map1;
                }
        );
    }
}

/**
 * Represents aggregated statistics for a product category.
 */
class CategoryStats {
    private double totalPrice;
    private double averagePrice;
    private long productCount;
    private Set<String> uniqueProductNames;

    // Constructor
    public CategoryStats() {
        this.totalPrice = 0;
        this.productCount = 0;
        this.uniqueProductNames = new HashSet<>();
    }

    /**
     * Adds a product to the statistics.
     *
     * @param product The product to add.
     */
    public void addProduct(Product product) {
        totalPrice += product.getPrice();
        productCount++;
        averagePrice = totalPrice / productCount;
        uniqueProductNames.add(product.getName());
    }

    /**
     * Merges another CategoryStats into this one.
     *
     * @param other The other CategoryStats to merge.
     * @return The merged CategoryStats.
     */
    public CategoryStats merge(CategoryStats other) {
        totalPrice += other.totalPrice;
        productCount += other.productCount;
        averagePrice = totalPrice / productCount;
        uniqueProductNames.addAll(other.uniqueProductNames);
        return this;
    }

    // Getters (omitted for brevity)

    // toString method for displaying statistics
    @Override
    public String toString() {
        return String.format("Total Price: $%.2f\nAverage Price: $%.2f\nProduct Count: %d\nUnique Products: %s",
                totalPrice, averagePrice, productCount, uniqueProductNames);
    }
}