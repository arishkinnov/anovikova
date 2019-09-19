package ru.anovikova.task4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        {
            System.out.println("Введите количество членов прогресии");
        }


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int difference = 2;


        int first = 1;
        int a = 1;
        System.out.println("Арифмитическая прогрессия:");
        do {
            System.out.print(first + (difference * (a - 1)) + " ");
            a++;

        }
        while (a <= number);


        System.out.println("");
        a = 1;
        System.out.println("Геометрическая прогрессия:");

        do {
            System.out.print(first * (int) (Math.pow(difference, (a - 1))) + " ");
            a++;

        }
        while (a <= number);






    }





}



