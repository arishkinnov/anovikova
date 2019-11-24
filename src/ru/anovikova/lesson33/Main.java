package ru.anovikova.lesson33;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фразу:");

        String value = sc.nextLine().replaceAll("[^а-яА-Яa-zA-Z]+", "");

        char[] chars = value.toCharArray();
        HashMap<Character, Integer> numberOfCharsMap = calculateCharactersMap(chars);

        Pair<Character, Integer> max = getMaxCharacter(numberOfCharsMap);

        System.out.println("Max letter is '" + max.getKey() + "' - " + max.getValue());

    }

    private static HashMap<Character, Integer> calculateCharactersMap(char[] chars) {
        HashMap<Character, Integer> numberOfCharsMap = new HashMap<>();

        for (Character current : chars) {
            if (numberOfCharsMap.containsKey(current)) {
                numberOfCharsMap.put(current, numberOfCharsMap.get(current) + 1);
            } else {
                numberOfCharsMap.put(current, 1);
            }
        }
        return numberOfCharsMap;
    }

    private static Pair<Character, Integer> getMaxCharacter(HashMap<Character, Integer> numberOfCharsMap) {
        Pair<Character, Integer> max = null;

        for (Map.Entry<Character, Integer> entry : numberOfCharsMap.entrySet()) {
            if (max == null) {
                max = new Pair<>(entry.getKey(), entry.getValue());
                continue;
            }
            if (entry.getValue() > max.getValue()) {
                max = new Pair<>(entry.getKey(), entry.getValue());
            }
        }
        return max;
    }
}
