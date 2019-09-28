package ru.anovikova.lesson8.task4;


import ru.anovikova.lesson8.task3.Fish;

import java.util.Date;

public class Main {
    public static void main(String [] args) {

        Contract contract = new Contract();
        contract.setDate(new Date());
        contract.setNumber(123654);
        contract.setItems(new String[]{"Первая строка", "Вторая строка"});

        Act act = DocumentConvector.converct(contract);

        System.out.println("Сформирован Акт " + act);



    }
}
