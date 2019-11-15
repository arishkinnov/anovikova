package ru.anovikova.Lesson30;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите слово: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        Map<Character, Long> collect =  word.chars()
                .mapToObj(i -> (char)i)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        )
                );

        Optional<Character> firstNonRepeat = collect.entrySet().stream()
                .filter( (e) -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        firstNonRepeat.ifPresent(
                character -> System.out.println("Первый неповторяющийся символ: " + character)
        );

        if (!firstNonRepeat.isPresent()) {
            System.out.println("Неповторяющихся символов нет");
        }
    }
}
