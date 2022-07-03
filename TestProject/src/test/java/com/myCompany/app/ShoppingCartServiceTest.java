package com.myCompany.app;

import com.myCompany.app.model.OrderItem;
import com.myCompany.app.model.Product;
import com.myCompany.app.service.ShoppingCartService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShoppingCartServiceTest {

    ShoppingCartService cart = new ShoppingCartService();

    Product p1 = new Product("p1", "toys", 100,false, 0, 1000);
    Product p2 = new Product( "p2", "hardware", 1000, true, 0.2, 10);
    Product p3 = new Product( "p3", "apparel", 100, true, 0.3,100);

    @Test
    public void testAddOrderItem(){
        int count = 1;
        List<OrderItem> items = cart.addOrderItem(p1,count);
        assertNotNull(items);
        assertEquals(1, items.size());
        assertEquals("p1", items.get(0).getProduct().getName());
    }

    @Test
    public void testGetShoppingCart(){
        List<OrderItem> orderItems = cart.getShoppingCart();
        assertNotNull(orderItems);
    }

    @Test
    public void testGetGrossPrice(){
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(p1,1));
        items.add(new OrderItem(p2,15));

        double actualGrossPrice = cart.getGrossPrice(items);
        double expectedGrossPrice = 1150;
        Assert.assertTrue("Equals", expectedGrossPrice - actualGrossPrice == 0);
    }

    @Test
    public void testIsItemAvailable(){
        OrderItem item = new OrderItem(p1, 200);
        boolean isItemAvailable = cart.isItemAvailable(item);

        assertEquals(false, isItemAvailable);
    }

    @Test
    public void testCalculateOfferAmount(){
        double offerAmount = 0;
        offerAmount = cart.calculateOfferAmount(new OrderItem(p1, 2));
        Assert.assertTrue("Equals", 0 - offerAmount == 0);

        offerAmount = cart.calculateOfferAmount(new OrderItem(p2,15));
        Assert.assertFalse("Not Equals", 0 - offerAmount == 0);

        offerAmount = cart.calculateOfferAmount(new OrderItem(p3,2));
        Assert.assertFalse("Not Equals", 0 - offerAmount == 0);
    }

    @Test
    public void testCalculateNetPrice(){
        double netPrice=0;
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(p1,1));
        items.add(new OrderItem(p2,15));

        netPrice = cart.calculateNetPrice(items);
        Assert.assertTrue("Not Equals", 1150 - netPrice > 0);

    }

}