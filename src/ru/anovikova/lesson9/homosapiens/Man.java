package ru.anovikova.lesson9.homosapiens;

public class Man extends Human {
    private String race;
    private Woman wife;

    public Man(String name, String race) {
       super(name);
        this.race = race;
    }

    public void setWife(Woman wife) {
        if (this.wife != null) {
            System.out.println("Этот мужчина уже женат");
            return;
        }
        this.wife = wife;
    }

    public boolean isMarried() {
        if (wife != null) {
            System.out.println(getName() + " женат на " + wife.getName());
            return true;
        } else {
            System.out.println(getName() + " не женат.");
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void think() {
        System.out.println("Мужчина " + getName() + " думает");

    }

    @Override
    public String getRace() {
        return race;
    }

    @Override
    public void run() {
        System.out.println("Мужчина " + getName() + " бежит.");

    }

    @Override
    public void swim() {
        System.out.println("Мужчина " + getName() + " плавает");

    }
}
