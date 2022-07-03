package com.myCompany.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myCompany.app.service.ShoppingCartService;
import com.myCompany.app.model.OrderItem;
import org.json.simple.JSONObject;

public class InventoryController {

    public String getOrderDetails() {
        ShoppingCartService cart = new ShoppingCartService();
        double totalOfferAmount = 0;
        for(OrderItem item : cart.getShoppingCart()){
            totalOfferAmount += cart.calculateOfferAmount(item);
        }

        JSONObject json = new JSONObject();
        json.put("grossAmount", cart.getGrossPrice(cart.getShoppingCart()));
        json.put("offerAmount", totalOfferAmount);
        json.put("netPrice", cart.calculateNetPrice(cart.getShoppingCart()));

        ObjectMapper mapper = new ObjectMapper();
        String items = "";
        try {
            items = mapper.writeValueAsString(cart.getShoppingCart());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String response = items +","+ json.toJSONString();

        return response;
    }


}
