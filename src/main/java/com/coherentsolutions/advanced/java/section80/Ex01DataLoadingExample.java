package com.coherentsolutions.advanced.java.section80;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates loading data from a CSV file into a list of custom objects.
 * This example reads a CSV file containing product information and loads it into a list of Product objects.
 */
public class Ex01DataLoadingExample {

    public static void main(String[] args) {
        String filePath = "src/main/resources/products.csv";
        List<Product> products = loadProducts(filePath);

        // Output the loaded products
        products.forEach(System.out::println);
    }

    /**
     * Loads products from a CSV file.
     *
     * @param filePath The path to the CSV file.
     * @return A list of Product objects.
     */
    public static List<Product> loadProducts(String filePath) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            // Skip header line
            br.readLine();

            // Read each line of the CSV file
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                // Create a new Product object and add it to the list
                Product product = new Product(
                        fields[0],                          // id
                        fields[1],                          // name
                        Double.parseDouble(fields[2]),      // price
                        fields[3],                          // category
                        Boolean.parseBoolean(fields[4])     // inStock
                );
                products.add(product);
            }
        } catch (IOException e) {
            System.err.println("Error loading products: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in CSV file: " + e.getMessage());
        }

        return products;
    }
}
