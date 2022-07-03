package com.myCompany.app.service;

import com.myCompany.app.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Product> products = new ArrayList<>();

    public List<Product> getProductItems(){
        Product p1 = new Product( "p1", "toys", 10, true, 0.2, 10);
        Product p2 = new Product( "p2", "toys", 10, true, 0.3,100);
        Product p3 = new Product( "p3", "electronics", 100, false, 0,5);

        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);

        return products;
    }
}
