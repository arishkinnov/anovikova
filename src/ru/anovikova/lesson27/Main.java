package ru.anovikova.lesson27;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Введите количество значений последовательности Фибоначчи:");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        printArray(FibonacciSeries.compile(size));
        printArray(FibonacciSeries.compileRecursion(size));
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
