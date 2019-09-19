package ru.anovikova.task3;

public class Main {
    public static void main(String[] args) {
        int n1 = 1;
        while (n1 < 11) {
            int n2 = 1;
            while (n2 < 11) {
                int mul = n1 * n2;
                System.out.print(mul + " ");
                n2++;
            }
            System.out.println();
            n1++;
        }
    }
}
