package com.coherentsolutions.advanced.java.section80;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates data transformation using streams.
 * Normalizes product names and categorizes products into broader categories.
 */
public class Ex03DataTransformationExample {

    public static void main(String[] args) {
        // Sample list of products
        List<Product> products = Arrays.asList(
                new Product("1", "laptop", 1200.00, "Computers", true),
                new Product("2", "Smartphone", 500.00, "Mobile Devices", true),
                new Product("3", "Refrigerator", 800.00, "Home Appliances", false),
                new Product("4", "Toaster", 25.00, "Kitchen Appliances", true)
        );

        // Transform product data
        List<Product> transformedProducts = products.stream()
                .map(product -> {
                    // Normalize product name to uppercase
                    product.setName(product.getName().toUpperCase());

                    // Categorize products into broader categories
                    String category = product.getCategory();
                    if ("Computers".equals(category) || "Mobile Devices".equals(category)) {
                        product.setCategory("Electronics");
                    } else if ("Home Appliances".equals(category) || "Kitchen Appliances".equals(category)) {
                        product.setCategory("Appliances");
                    }

                    return product;
                })
                .collect(Collectors.toList());

        // Output the transformed products
        transformedProducts.forEach(System.out::println);
    }
}