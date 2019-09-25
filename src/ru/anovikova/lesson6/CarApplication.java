package ru.anovikova.lesson6;

import ru.anovikova.lesson6.car.Car;
import ru.anovikova.lesson6.car.Lexus;
import ru.anovikova.lesson6.car.Porshe;

public class CarApplication {
    public static void main(String[] args){
        Car x450White = new Lexus("Белый", "x450");
        x450White.isRunning();
        x450White.run();
        x450White.isRunning();
        x450White.drive();
        x450White.stop();
        x450White.isStoping();
        x450White.carOff();
        x450White.isCaroff();

        Car x450Blue = new Porshe("Синий", "x450");
        x450Blue.isRunning();
        x450Blue.run();
        x450Blue.isRunning();
        x450Blue.drive();
    }
}
