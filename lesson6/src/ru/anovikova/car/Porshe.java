package ru.anovikova.car;

public class Porshe extends Car {
    private String color;
    private String model;

    public Porshe(String color, String model) {
        super(color, model, new Manufacturer("Porshe", "kjnjkhnbjkl"));
        this.color = color;
        this.model = model;
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
