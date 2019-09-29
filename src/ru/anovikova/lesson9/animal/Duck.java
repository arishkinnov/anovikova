package ru.anovikova.lesson9.animal;

import ru.anovikova.lesson9.actions.Fly;
import ru.anovikova.lesson9.actions.Run;
import ru.anovikova.lesson9.actions.Swim;

public class Duck extends Animal implements Run, Swim, Fly {
     private String name;

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Утка " + name + " бежит.");
    }

    @Override
    public void swim() {
        System.out.println("Утка  " + name + " плавает.");
    }

    @Override
    public void fly() {
        System.out.println("Утка  " + name + " летает.");

    }
}
