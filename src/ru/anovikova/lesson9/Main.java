package ru.anovikova.lesson9;


import ru.anovikova.lesson9.animal.Cat;
import ru.anovikova.lesson9.animal.Duck;
import ru.anovikova.lesson9.animal.Hamster;
import ru.anovikova.lesson9.homosapiens.Man;
import ru.anovikova.lesson9.homosapiens.Woman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] args) {
        Duck duckBob = new Duck("Боб");
        duckBob.swim();
        duckBob.fly();
        duckBob.run();
        System.out.println("");

        Cat cat = new Cat("Барсик");
        cat.run();
        cat.swim();
        System.out.println("");

        Hamster hamsterTom = new Hamster("Том");
        hamsterTom.run();
        System.out.println("");

        Woman womanAlisa = new Woman("Алиса", "евро");
        womanAlisa.isMarried();
        womanAlisa.run();
        womanAlisa.think();
        womanAlisa.swim();
        System.out.println("");

        Man manKpis = new Man("Крис", "евро");
        manKpis.isMarried();
        manKpis.run();
        manKpis.swim();
        manKpis.think();
        System.out.println("");

        womanAlisa.setHusband(manKpis);
        manKpis.setWife(womanAlisa);
        System.out.println("");

        manKpis.isMarried();
        womanAlisa.isMarried();
        System.out.println("");


    }
}
