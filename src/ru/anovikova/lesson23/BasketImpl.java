package ru.anovikova.lesson23;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BasketImpl implements Basket {
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public void addProduct(String productName, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                product.addQuantity(quantity);
                return;
            }
        }
        products.add(new Product(productName, quantity));
    }

    @Override
    public void removeProduct(String productName) {
        for (Iterator<Product> iterator =  products.iterator(); iterator.hasNext();) {
            Product product = iterator.next();
            if (product.getName().equals(productName)) {
                iterator.remove();
                return;
            }
        }
    }

    @Override
    public void updateProductQuantity(String productName, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                product.addQuantity(quantity);
                return;
            }
        }
        throw new IllegalArgumentException("Товар " + productName + " не найден в корзине");
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        ArrayList<String> names = new ArrayList<>(products.size());
        for (Product product : products) {
            names.add(product.getName());
        }
        return names;
    }

    @Override
    public int getProductQuantity(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product.getQuantity();
            }
        }

        throw new IllegalArgumentException("Товар " + productName + " не найден в корзине");
    }
}
