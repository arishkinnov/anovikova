package ru.anovikova.lesson25.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BasketImpl implements Basket {
    private HashMap<String, Integer> products = new HashMap<>();

    @Override
    public void addProduct(String productName, int quantity) {
        products.put(productName, quantity);
    }

    @Override
    public void removeProduct(String productName) {
        products.remove(productName);
    }

    @Override
    public void updateProductQuantity(String productName, int quantity) {
        if (products.containsKey(productName)) {
            int oldQuantity = products.get(productName);
            products.put(productName, oldQuantity + quantity);
            return;
        }
        throw new IllegalArgumentException("Товар " + productName + " не найден в корзине");
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        List<String> productsNames = new ArrayList<>(products.keySet().size());
        productsNames.addAll(products.keySet());
        return productsNames;
    }

    @Override
    public int getProductQuantity(String productName) {
        if (products.containsKey(productName)) {
            return products.get(productName);
        }

        throw new IllegalArgumentException("Товар " + productName + " не найден в корзине");
    }
}
