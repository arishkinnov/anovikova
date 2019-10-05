package ru.anovikova.lesson9.homosapiens;

import ru.anovikova.lesson9.actions.Run;
import ru.anovikova.lesson9.actions.Swim;
import ru.anovikova.lesson9.animal.Animal;

public abstract class Human extends Animal implements Run, Swim {

    public Human(String name) {
        super(name);
    }

    public abstract void think();
    public abstract String getRace();
}
