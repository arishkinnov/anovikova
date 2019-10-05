package ru.anovikova.lesson9.animal;

import ru.anovikova.lesson9.actions.Run;
import ru.anovikova.lesson9.actions.Swim;

public class Cat extends Animal implements Run, Swim {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Кошка " + getName() + " бежит.");
    }

    @Override
    public void swim() {
        System.out.println("Кошка " + getName() + " плавает.");
    }
}
