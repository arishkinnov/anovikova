package ru.anovikova.lesson3.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int gross = Integer.parseInt(reader.readLine());
        double net = gross * 0.87;
        System.out.println( (int) net + " руб.");
    }

}

