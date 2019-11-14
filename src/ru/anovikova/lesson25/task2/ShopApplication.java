package ru.anovikova.lesson25.task2;

public class ShopApplication {
    public static void main(String[] args) {
        Basket basket = new BasketImpl();
        printBasket(basket);
        basket.addProduct("Рис", 1);
        printBasket(basket);
        basket.updateProductQuantity("Рис", 1);
        printBasket(basket);
        basket.addProduct("Вода", 3);
        basket.addProduct("Печеньки", 10);
        basket.addProduct("Пиво", 20);
        printBasket(basket);
        basket.removeProduct("Пиво");
        printBasket(basket);
        basket.clear();
        printBasket(basket);

    }

    private static void printBasket(Basket basket) {
        int total = 0;
        if (basket.getProducts().isEmpty()) {
            System.out.println();
            System.out.println("Ваша корзина пуста");
            System.out.println();
            return;
        }
        System.out.println("============================");
        System.out.println("=      Ваша корзина        =");
        System.out.println("============================");
        for (String productName : basket.getProducts()) {
            int productQuantity = basket.getProductQuantity(productName);
            total = total + productQuantity;
            System.out.printf("%20s - %3d шт\n", productName, productQuantity);
        }
        System.out.println("============================");
        System.out.printf("%26s \n", "Итого: " + total + " шт.");
        System.out.println("============================");
    }
}
