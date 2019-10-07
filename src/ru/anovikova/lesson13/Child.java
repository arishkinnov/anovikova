package ru.anovikova.lesson13;

public class Child {
    public String eat(Food food) {
        try {

            switch (food) {
                case JUICE:
                case APPLE:
                case CARROT:
                    return "Съел за обе щеки " + food;
                default:
                    throw new ChildException("Я не люблю " + food);
            }
        } finally {
            System.out.println("Спасибо, Мама!");
        }
    }

}
