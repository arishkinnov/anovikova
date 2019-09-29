package ru.anovikova.lesson9.animal;

import ru.anovikova.lesson9.actions.Run;
import ru.anovikova.lesson9.actions.Swim;

public class Cat extends Animal implements Run, Swim {
     private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Кошка " + name + " бежит.");
    }

    @Override
    public void swim() {
        System.out.println("Кошка " + name + " плавает.");
    }
}
