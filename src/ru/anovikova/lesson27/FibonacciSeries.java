package ru.anovikova.lesson27;

public class FibonacciSeries {
    public static int[] compile(int size) {
        size = Math.max(size, 2);
        int[] fibonacciSeries = new int[size];
        fibonacciSeries[0] = 0;
        fibonacciSeries[1] = 1;
        for (int i = 2; i < size; ++i) {
            fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
        }
        return fibonacciSeries;
    }

    public static int[] compileRecursion(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("кол-во элементов не должно быть меньше 2х");
        }
        int[] fibonacciSeries = new int[size];
        fibonacciSeries[0] = 0;
        fibonacciSeries[1] = 1;
        for (int i = 2; i < size; ++i) {
            fibonacciSeries[i] = fibonacci(i);
        }
        return fibonacciSeries;
    }

    private static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
