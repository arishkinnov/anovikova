package ru.anovikova.lesson4.task1;

class Main {

    private static int min(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(min(22, 45));
        System.out.println(min(12, 5));
        System.out.println(min(333, 321));
        System.out.println(min(37, 1));

    }
}
