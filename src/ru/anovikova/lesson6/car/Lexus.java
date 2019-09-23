package ru.anovikova.lesson6.car;

public class Lexus extends Car {
    private String color;
    private String model;

    public Lexus(String color, String model) {
        super(color, model, new Manufacturer("Lexus", "kjnjkhnbjkl"));
        this.color = color;
        this.model = model;
    }

    @Override
    public void run() {
        running=true;
        System.out.println(manufacturer.getName() + ' ' + model + ' ' + color + " запустил двигатель");
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
