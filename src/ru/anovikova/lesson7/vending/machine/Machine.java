package ru.anovikova.lesson7.vending.machine;

public class Machine {
    private int account = 0;

    public void sell(int numberDrink) throws InterruptedException {
        Drink drink = Drink.findByNumber(numberDrink);
        if (drink == null) {
            System.out.println("Вы выбрали несуществующий напиток.");
            showMenu();
            return;
        }
        if ( account < drink.getPrice()) {
            System.out.println("Внесите еще " + (drink.getPrice() - account));
        } else {
            System.out.println("Ваш напиток " + drink.getTitle() + " готовится.");
            account -= drink.getPrice();
            Thread.sleep(5000);
            System.out.println("Ваш напиток " + drink.getTitle() + " готов.");
            toChange();
        }
    }

    public void toChange() {
        System.out.println("Ваша сдача " + account);
        account = 0;
    }

    public void showMenu() {
        System.out.println("В меню есть:");
        for (Drink drink : Drink.values()) {
            System.out.println(String.format("%s - %s цена %d рублей", drink.getNumberDrink(), drink.getTitle(), drink.getPrice()));
        }
    }

    public void replenish(int amount) {
        account += amount;
        System.out.println("На вашем счете " + account + " рублей." );
    }
}
