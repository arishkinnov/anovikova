package ru.anovikova.lesson19;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Scanner;

import static java.math.BigDecimal.ROUND_HALF_EVEN;

public class CashVoucher {
    private static final String HEADER_FORMAT = "%-20s %6s %10s %11s";
    private static final String ROW_FORMAT = "%-20s %6.2f x %6.3f %13s \n";
    private static final String TOTAL_FORMAT = "%-41s %8.2f\n";

    public static void main(String[] args) {
            try(Scanner scanner = new Scanner(new File("files/lesson19/products.txt"))) {
                scanner.useDelimiter("\n");
                ArrayList<Product> products = new ArrayList<>();
                int count = 0;
                Product product = null;
                while (scanner.hasNext()) {
                    FieldType fieldType;
                    if (count < 3) {
                        fieldType = FieldType.findByIndex(count);
                    } else {
                        fieldType = FieldType.findByIndex(count % 3);
                    }
                    boolean isNewProduct = FieldType.TITLE == fieldType;
                    if (isNewProduct) {
                        product = new Product();
                    }

                    String value = scanner.next();
                    fillProduct(product, fieldType, value);

                    boolean isEndProduct = FieldType.AMOUNT == fieldType;
                    if (isEndProduct) {
                        products.add(product);
                    }

                    count++;
                }
                System.out.println(String.format(HEADER_FORMAT, "Наименование", "Цена", "Кол-во", "Стоимость"));
                BigDecimal total = new BigDecimal(0).setScale(2, ROUND_HALF_EVEN);
                for (Product p : products) {
                    String sum = String.format("%.2f", p.getAmount() * p.getPrice()).replaceAll(",", ".");
                    total = total.add(new BigDecimal(p.getAmount() * p.getPrice()).setScale(2, ROUND_HALF_EVEN));
                    System.out.printf(ROW_FORMAT, p.getTitle(), p.getPrice(), p.getAmount(), String.format("=%s", sum));
                }
                System.out.printf(TOTAL_FORMAT, "Итого:", total.doubleValue());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }





    }

    private static void fillProduct(Product product, FieldType fieldType, String value) {
        switch (fieldType) {
            case TITLE:
                product.setTitle(value);
                break;
            case PRICE:
                product.setPrice(Double.parseDouble(value));
                break;
            case AMOUNT:
                product.setAmount(Double.parseDouble(value));
                break;
        }
    }
}
