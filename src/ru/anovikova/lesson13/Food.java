package ru.anovikova.lesson13;

public enum Food {
    CARROT("каша"),
    APPLE("яблоко"),
    JUICE("сок"),
    PORRIDGE("каша"),
    SOUP("суп");

    private final String title;

    Food(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
