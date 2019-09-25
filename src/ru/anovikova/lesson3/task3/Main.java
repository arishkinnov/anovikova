package ru.anovikova.lesson3.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int second  = Integer.parseInt(reader.readLine());
        int hour = second / 3600;
        System.out.println(hour + " час");
    }

}

