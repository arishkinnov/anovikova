package ru.anovikova.lesson27;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Введите количество значений последовательности Фибоначчи:");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        try {
            printArray(FibonacciSeries.compileRecursion(size));
            printArray(FibonacciSeries.compile(size));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
