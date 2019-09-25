package ru.anovikova.lesson7.vending.machine;

public enum Drink {
    TEA(25,1, "Чай"),
    ESPRESSO(30,2, "Экспрессо"),
    LATTE(30,3, "Латте"),
    COCOA(35,4, "Какао"),
    WATER(15,5, "Вода"),
    ;
    private final int price;
    private final int numberDrink;
    private final String title;

    Drink(int price, int numberDrink, String title) {
        this.price = price;
        this.numberDrink = numberDrink;
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public int getNumberDrink() {
        return numberDrink;
    }

    public String getTitle() {
        return title;
    }

    public static Drink findByNumber(int number) {
        for (Drink drink : Drink.values()) {
            if (drink.getNumberDrink() == number) {
                return drink;
            }
        }
        return null;
    }
}
