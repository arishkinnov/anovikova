package ru.anovikova.lesson19;

import java.util.Objects;

public class Product {
   private String title;
   private double price;
   private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Double.compare(product.amount, amount) == 0 &&
                Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, amount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
