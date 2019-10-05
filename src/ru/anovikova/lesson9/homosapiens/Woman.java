package ru.anovikova.lesson9.homosapiens;

public class Woman extends Human {
    private String race;
    private Man husband;

    public Woman(String name, String race) {
        super(name);
        this.race = race;
    }

    public void setHusband(Man husband) {
        if (this.husband != null) {
            System.out.println("Эта женщина уже замужем");
            return;
        }
        this.husband = husband;
    }

    public boolean isMarried() {
        if (husband != null) {
            System.out.println(getName() + " замужем за " + husband.getName());
            return true;
        } else {
            System.out.println(getName() + " не замужем.");
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void think() {
        System.out.println("Женщина " + getName() + " думает");

    }

    @Override
    public String getRace() {
        return race;
    }

    @Override
    public void run() {
        System.out.println("Женщина " + getName() + " бежит.");

    }

    @Override
    public void swim() {
        System.out.println("Женщина " + getName() + " плавает");

    }
}
