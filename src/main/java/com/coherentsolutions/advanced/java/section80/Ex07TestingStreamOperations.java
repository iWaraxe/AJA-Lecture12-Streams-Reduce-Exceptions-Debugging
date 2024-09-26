package com.coherentsolutions.advanced.java.section80;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates writing tests for stream operations using JUnit.
 */
public class Ex07TestingStreamOperations {

    /**
     * Tests the data cleaning and filtering operation.
     */
    @Test
    public void testDataCleaningAndFiltering() {
        List<Product> products = Arrays.asList(
                new Product("1", "Laptop", 1200.00, "Electronics", true),
                new Product("2", "Smartphone", -500.00, "Electronics", true),
                new Product("3", null, 300.00, "Electronics", true),
                new Product("4", "Refrigerator", 800.00, "Appliances", false),
                new Product("5", "Toaster", 0.00, "Appliances", true)
        );

        List<Product> validProducts = products.stream()
                .filter(product -> product.getPrice() > 0)
                .filter(product -> product.getName() != null)
                .filter(product -> product.getCategory() != null)
                .toList();

        assertEquals(2, validProducts.size());
        assertTrue(validProducts.stream().allMatch(p -> p.getPrice() > 0));
        assertTrue(validProducts.stream().noneMatch(p -> p.getName() == null));
    }

    /**
     * Tests the data transformation operation.
     */
    @Test
    public void testDataTransformation() {
        List<Product> products = Arrays.asList(
                new Product("1", "laptop", 1200.00, "Computers", true),
                new Product("2", "Smartphone", 500.00, "Mobile Devices", true)
        );

        List<Product> transformedProducts = products.stream()
                .map(product -> {
                    product.setName(product.getName().toUpperCase());
                    String category = product.getCategory();
                    if ("Computers".equals(category) || "Mobile Devices".equals(category)) {
                        product.setCategory("Electronics");
                    }
                    return product;
                })
                .toList();

        assertEquals("LAPTOP", transformedProducts.get(0).getName());
        assertEquals("Electronics", transformedProducts.get(0).getCategory());
        assertEquals("SMARTPHONE", transformedProducts.get(1).getName());
        assertEquals("Electronics", transformedProducts.get(1).getCategory());
    }
}