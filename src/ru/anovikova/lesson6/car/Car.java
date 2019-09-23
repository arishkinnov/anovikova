package ru.anovikova.lesson6.car;

public abstract class Car {
    protected String color;
    protected String model;
    protected Manufacturer manufacturer;
    protected boolean running = false;
    protected boolean driving = false;

    public Car(String color, String model, Manufacturer manufacturer) {
        this.color = color;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public abstract void run();
    public abstract void carOff();

    public abstract void drive();
    public abstract void stop();

    public void isRunning() {
        if (running) {
            System.out.println(manufacturer.getName() + ' ' + model + ' ' + color + " запущен");
        } else {
            System.out.println(manufacturer.getName() + ' ' + model + ' ' + color + " заглушен");
        }
    }

    public void isDriving() {
        System.out.println(manufacturer.getName() + ' ' + model + ' ' + color + " запустил двигатель");
    }

    public void isStoping() {
        System.out.println(manufacturer.getName() + ' ' + model + ' ' + color + " остановился");

    }

    public void isCaroff(){
        System.out.println(manufacturer.getName() + ' ' + model + ' ' + color + " заглох");
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer=" + manufacturer +
                ", running=" + running +
                ", driving=" + driving +
                '}';
    }
}
