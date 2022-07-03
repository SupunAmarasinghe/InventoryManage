package com.myCompany.app.model;

import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private String category;
    private int quantity;
    private boolean offer;
    private double offerPercentage;
    private double price;

    public Product(String name, String category, int quantity, boolean offer, double offerPercentage, double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.offer = offer;
        this.offerPercentage = offerPercentage;
        this.price = price;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isOffer() {
        return offer;
    }

    public void setOffer(boolean offer) {
        this.offer = offer;
    }

    public double getOfferPercentage() {
        return offerPercentage;
    }

    public void setOfferPercentage(double offerPercentage) {
        this.offerPercentage = offerPercentage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
