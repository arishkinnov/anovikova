package ru.anovikova.lesson21.task2;

public class ArrayRevercer {

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

        reverse(array);
        reverse(array2);

        printArray(array);
        printArray(array2);
    }

    private static void reverse(int[][] array) {
        for (int[] value1 : array) {
            int maxIteration = getMaxIteration(array.length);
            int lastIndex = array.length - 1;
            for (int index = 0; index < maxIteration; index++) {
                int[] begin = array[index];
                int[] end = array[lastIndex - index];
                array[index] = end;
                array[lastIndex - index] = begin;
            }
            reverse(value1);
        }
    }

    private static void reverse(int[] array) {
        int maxIteration = getMaxIteration(array.length);
        int lastIndex = array.length - 1;
        for (int index = 0; index < maxIteration; index++) {
            int begin = array[index];
            int end = array[lastIndex - index];
            array[index] = end;
            array[lastIndex - index] = begin;
        }
    }

    private static int getMaxIteration(int arrayLength) {
        boolean isEvenLength = arrayLength % 2 == 0;
        int maxIteration;
        if (isEvenLength) {
            maxIteration = arrayLength / 2;
        } else {
            maxIteration = (arrayLength - 1) / 2;
        }
        return maxIteration;
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
