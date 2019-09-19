package ru.anovikova.task1;

class Main {
    public static int min(int a, int b) {

        int m;
        if (a > b)
            m = b;
        else m = a;
        return m;
    }


    public static void main(String[] args) {
        System.out.println(min(22, 45));
        System.out.println(min(12, 5));
        System.out.println(min(333, 321));
        System.out.println(min(37, 1));

    }

}
