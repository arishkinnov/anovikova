package ru.anovikova.lesson8.task4;

import java.util.Arrays;
import java.util.Date;

public class Act {
    private int number;
    private Date date;
    private String [] items;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Act{" +
                "number=" + number +
                ", date=" + date +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
