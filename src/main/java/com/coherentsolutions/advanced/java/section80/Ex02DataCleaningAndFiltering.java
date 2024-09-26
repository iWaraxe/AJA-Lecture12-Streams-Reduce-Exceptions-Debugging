package com.coherentsolutions.advanced.java.section80;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates data cleaning and filtering using streams.
 * Filters out invalid products based on certain criteria.
 */
public class Ex02DataCleaningAndFiltering {

    public static void main(String[] args) {
        // Sample list of products
        List<Product> products = Arrays.asList(
                new Product("1", "Laptop", 1200.00, "Electronics", true),
                new Product("2", "Smartphone", -500.00, "Electronics", true),
                new Product("3", null, 300.00, "Electronics", true),
                new Product("4", "Refrigerator", 800.00, "Appliances", false),
                new Product("5", "Toaster", 0.00, "Appliances", true)
        );

        // Filter out products with invalid data
        List<Product> validProducts = products.stream()
                .filter(product -> product.getPrice() > 0)         // Exclude products with non-positive price
                .filter(product -> product.getName() != null)      // Exclude products with null name
                .filter(product -> product.getCategory() != null)  // Exclude products with null category
                .collect(Collectors.toList());

        // Output the valid products
        validProducts.forEach(System.out::println);
    }
}
