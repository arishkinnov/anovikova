package ru.anovikova.lesson14.vending.machine;

import org.apache.log4j.Logger;

public class Machine {
    public static final Logger logger = Logger.getLogger(Machine.class);
    private int account = 0;

    public void sell(int numberDrink) throws InterruptedException {
        logger.info("Начинаю готовить напиток №" + numberDrink);
        Drink drink = Drink.findByNumber(numberDrink);
        if (drink == null) {
            logger.warn("Напиток №" + numberDrink + " не найден в перечислении Drink");
            System.out.println("Вы выбрали несуществующий напиток.");
            showMenu();
            return;
        }
        if ( account < drink.getPrice()) {
            logger.warn("При приготовлении напитка №" + numberDrink + " не достаточно средств");
            System.out.println("Внесите еще " + (drink.getPrice() - account));
        } else {
            System.out.println("Ваш напиток " + drink.getTitle() + " готовится.");
            account -= drink.getPrice();
            Thread.sleep(5000);
            System.out.println("Ваш напиток " + drink.getTitle() + " готов.");
            toChange();
        }
        logger.info("Напиток №" + numberDrink + " пригоовлен");
    }

    public void toChange() {
        logger.debug("Выдача сдачи " + account + " руб");
        System.out.println("Ваша сдача " + account);
        account = 0;
        logger.debug("Баланс = " + account + " руб");
    }

    public void showMenu() {
        System.out.println("В меню есть:");
        for (Drink drink : Drink.values()) {
            System.out.println(String.format("%s - %s цена %d рублей", drink.getNumberDrink(), drink.getTitle(), drink.getPrice()));
        }
    }

    public void replenish(int amount) {
        logger.debug("Пополнение баланса на " + amount + " руб");
        account += amount;
        System.out.println("На вашем счете " + account + " рублей." );
        logger.debug("Баланс = " + account + " руб");
    }
}
