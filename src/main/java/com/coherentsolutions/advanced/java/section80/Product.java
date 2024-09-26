package com.coherentsolutions.advanced.java.section80;

/**
 * Represents a product with various attributes.
 */
public class Product {
    private String id;
    private String name;
    private double price;
    private String category;
    private boolean inStock;

    // Constructor
    public Product(String id, String name, double price, String category, boolean inStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.inStock = inStock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    // toString method for displaying product information
    @Override
    public String toString() {
        return String.format("Product{id='%s', name='%s', price=%.2f, category='%s', inStock=%s}",
                id, name, price, category, inStock);
    }
}