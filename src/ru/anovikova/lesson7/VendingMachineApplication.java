package ru.anovikova.lesson7;

import ru.anovikova.lesson7.vending.machine.Machine;

public class VendingMachineApplication {

    public static void main(String[] args) throws InterruptedException {
        Machine machine = new Machine();

        machine.showMenu();

        machine.replenish(10);

        machine.sell(1);

        machine.replenish(50);

        machine.sell(10);

        machine.sell(1);
    }

}
