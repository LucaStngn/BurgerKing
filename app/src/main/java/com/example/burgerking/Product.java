/*
  Copyright 2019 Luca Steingen
 */

package com.example.burgerking;

public class Product {
    private int productID;
    private String name;
    private String description;
    private int amount;
    private double price;
    private int imageDrawableId;

    public Product(int productID, String name, String description, double price, int amount, int imageDrawableId) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.imageDrawableId = imageDrawableId;                                                     // temporary way of showing images.
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public void setImageDrawableId(int imageDrawableId) {
        this.imageDrawableId = imageDrawableId;
    }
}