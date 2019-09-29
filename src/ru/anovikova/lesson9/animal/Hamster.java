package ru.anovikova.lesson9.animal;

import ru.anovikova.lesson9.actions.Run;

public class Hamster extends Animal implements Run {
    private String name;

    public Hamster(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Хомяк " + name + " бежит.");
    }
}
