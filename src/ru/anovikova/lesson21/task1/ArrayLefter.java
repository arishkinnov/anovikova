package ru.anovikova.lesson21.task1;

public class ArrayLefter {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {0,1,2,3,4,5,6,7,8,9,10},
                {0,1,2,3,4,5,6,7,8,9},
                {0,1,2,3,4,5,6,7,8},
                {0,1,2,3,4,5,6,7},
                {0,1,2,3,4,5,6},
                {0,1,2,3,4,5},
                {0,1,2,3,4},
                {0,1,2,3},
                {0,1,2},
                {0,1},
                {1}
        };

        int[][] array2 = new int[][]{
                {1},
                {0,1},
                {0,1,2},
                {0,1,2,3},
                {0,1,2,3,4},
                {0,1,2,3,4,5},
                {0,1,2,3,4,5,6},
                {0,1,2,3,4,5,6,7},
                {0,1,2,3,4,5,6,7,8},
                {0,1,2,3,4,5,6,7,8,9},
                {0,1,2,3,4,5,6,7,8,9,10}
        };

        printArray(array);
        printArray(array2);

        toLeft(array);
        toLeft(array2);

        printArray(array);
        printArray(array2);
    }

    private static void toLeft(int[][] array) {
        for (int[] value1 : array) {
            int lastIndex = value1.length - 1;
            for (int index = 0; index < lastIndex; index++) {
                value1[index] = value1[index + 1];
            }
            toZero(value1, lastIndex);
        }
    }

    private static void toZero(int[] value1, int index) {
        value1[index] = 0;
    }

    private static void printArray(int[][] array) {
        for (int[] value1 : array) {
            for (int value : value1) {
                System.out.print(value + " ");
            }
            System.out.println("");
        }
        System.out.println("=====================");
    }
}
