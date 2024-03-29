package ru.anovikova.lesson6.car;

public class Porshe extends Car {

    public Porshe(String color, String model) {
        super(color, model, new Manufacturer("Porshe", "kjnjkhnbjkl"));
    }

    @Override
    public void run() {
        running=false;
        System.out.println(manufacturer.getName() + ' ' + model + ' ' + color + " не запустил двигатель, потому что я не люблю его");
    }

    @Override
    public void carOff() {
        running=false;
    }

    @Override
    public void drive() {
        if (running) {
            driving = true;
            System.out.println(manufacturer.getName() + ' ' + model + ' ' + color + " поехал");
        } else {
            System.out.println(manufacturer.getName() + ' ' + model + ' ' + color + " стоит на месте");
        }
    }

    @Override
    public void stop() {
        driving = false;
    }
}
