package ru.anovikova.lesson2.task2;

public class Main {

    public static void main(String[] args) {
        int gross = Integer.parseInt(args[0]);
        double net = gross * 0.87;
        System.out.println( (int) net + " руб.");
    }
}
