package ru.novikova.task4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int targetNumber = (int) (Math.random() * 100);

        System.out.println("Я загадываю число от 0 до 100..");

        int lastPosition = 0;
        int difference;
        while (true){
            int lastDistance = Math.abs(targetNumber - lastPosition);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int currentPosition = Integer.parseInt(reader.readLine());

            if (currentPosition == targetNumber) {
                System.out.println("Угадали!!!");
                break;
            }

            int currentDistance = Math.abs(targetNumber - currentPosition);
            difference = lastDistance - currentDistance;

            if (difference == 0) {
                System.out.println("Вы стоите на месте");
            } else if (difference > 0) {
                System.out.println("Горячо");
            } else {
                System.out.println("Холодно");
            }

            lastPosition = currentPosition;
        }




    }
}

