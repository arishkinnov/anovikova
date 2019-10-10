package ru.anovikova.lesson14;

import org.apache.log4j.Logger;
import ru.anovikova.lesson14.vending.machine.Machine;

public class VendingMachineApplication {

    public static final Logger logger = Logger.getLogger(VendingMachineApplication.class);

    public static void main(String[] args) throws InterruptedException {
        logger.debug("Запущено приложение VendingMachineApplication");
        try {
            Machine machine = new Machine();
            logger.debug("Создан экземпляр вендингового автомата Machine: " + machine.hashCode());
            logger.debug("Начинается эмуляция вывода меню");
            machine.showMenu();

            logger.debug("Начинается эмуляция ввода денежных средств 10");
            machine.replenish(10);

            logger.debug("Начинается эмуляция выбора напитка 1");
            machine.sell(1);

            logger.debug("Начинается эмуляция ввода денежных средств 50");
            machine.replenish(50);

            logger.debug("Начинается эмуляция выбора напитка 50");
            machine.sell(10);

            logger.debug("Начинается эмуляция выбора напитка 1");
            machine.sell(1);
        } catch (Exception e) {
            logger.error("Во врмя работы приложения возникла ошибка: ", e);
        }
        logger.debug("Приложение VendingMachineApplication завершило работу");
    }

}
