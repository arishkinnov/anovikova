package ru.anovikova.lesson13;

public class Child {
    public String eat(Food food) {
        try {

            switch (food) {
                case JUICE:
                case APPLE:
                case CARROT:
                    return "Съел за обе щеки " + food.getTitle();
                default:
                    throw new ChildException("Я не люблю " + food.getTitle());
            }
        } finally {
            System.out.println("Спасибо, Мама!");
        }
    }

}
