package ru.anovikova.lesson3.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int volume = Integer.parseInt(reader.readLine());
        int price = 43;
        System.out.println(volume * price + " руб.");
    }

}

