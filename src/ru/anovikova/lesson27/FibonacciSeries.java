package ru.anovikova.lesson27;

public class FibonacciSeries {
    public static int[] compile(int size) {
        int[] fibonacciSeries = new int[size];
        fibonacciSeries[0] = 0;
        fibonacciSeries[1] = 1;
        for (int i = 2; i < size; ++i) {
            fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
        }
        return fibonacciSeries;
    }

    public static int[] compileRecursion(int size) {
        int[] fibonacciSeries = new int[size];
        fibonacciSeries[0] = 0;
        fibonacciSeries[1] = 1;
        for (int i = 0; i < size; ++i) {
            fibonacciSeries[i] = fibonacci(i);
        }
        return fibonacciSeries;
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
