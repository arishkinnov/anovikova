package ru.anovikova.lesson13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Mother {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Arrays.stream(Food.values()).forEach(System.out::println);

        String food = reader.readLine();


        Food food1 = Food.valueOf(food);

        Child child = new Child();
        String reply;
        try {
            reply = child.eat(food1);
        } catch (Exception e) {
            reply = e.getMessage();
        }

        System.out.println(reply);
    }

}
