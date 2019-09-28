package ru.anovikova.lesson8.task4;

public class DocumentConvector {
    public static Act converct(Contract contract) {
        Act act = new Act();
        act.setDate(contract.getDate());
        act.setItems(contract.getItems());
        act.setNumber(contract.getNumber());
        return act;
    }
}
