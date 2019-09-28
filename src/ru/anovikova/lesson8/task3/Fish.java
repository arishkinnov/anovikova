package ru.anovikova.lesson8.task3;

public class Fish {
    private static Integer count = 0;

    public Fish() {
        count++;
    }

    public static Integer getCount() {
        return count;
    }
}
