package com.product_session_10.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cart;

    public Cart() {
        cart = new HashMap<>();
    }

    public void addToCart(Product product) {
        if (cart.containsKey(product)) {
            cart.replace(product, cart.get(product), cart.get(product) + 1);
        } else {
            cart.put(product, 1);
        }
    }

    public void removeProduct(Product product) {
        cart.remove(product);
    }

    public int getQuantity(Product product) {
        return cart.get(product);
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

}
