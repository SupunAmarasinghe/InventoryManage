package com.myCompany.app.service;

import com.myCompany.app.model.OrderItem;
import com.myCompany.app.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartService {

    public List<OrderItem> orderItems = new ArrayList<>();

    public static final double PRODUCT_PRICE_FOR_OFFER = 100;
    public static final int PRODUCT_QUANTITY_FOR_OFFER = 10;

    ProductService productService = new ProductService();

    public List<OrderItem> addOrderItem(Product p, int count){
        OrderItem item = new OrderItem(p, count);
        orderItems.add(item);

        return orderItems;
    }

    public List<OrderItem> getShoppingCart() {
        List<Product> products = productService.getProductItems();
        int count = 10;
        for(Product product : products){
            addOrderItem(product, count++);
        }
        return orderItems;
    }

    public double getGrossPrice(List<OrderItem> items){
        double grossPrice = 0;
        for(OrderItem orderItem : items){
            grossPrice += orderItem.getProduct().getPrice() * orderItem.getCount();
        }
        return grossPrice;
    }

    public boolean isItemAvailable(OrderItem item){
        boolean isItemAvailable = false;

        if(item.getCount() < item.getProduct().getQuantity())
            isItemAvailable = true;

        return isItemAvailable;
    }

    public double calculateOfferAmount(OrderItem item){

        if(item.getProduct().isOffer()){

            double totalProductPrice = item.getProduct().getPrice() * item.getCount();

            if(totalProductPrice > PRODUCT_PRICE_FOR_OFFER || item.getCount() > PRODUCT_QUANTITY_FOR_OFFER){
                return totalProductPrice * item.getProduct().getOfferPercentage();
            }
        }
        return 0;
    }

    public double calculateNetPrice(List<OrderItem> items){
        double grossPrice = getGrossPrice(items);
        double totalOfferAmount = 0;

        for(OrderItem orderItem: items){
            totalOfferAmount += calculateOfferAmount(orderItem);
        }

        return grossPrice - totalOfferAmount;
    }
}
