package ru.anovikova.lesson31;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите слово: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        System.out.println("Слово " + word + " это палиндром (stringBuilder) ? - " + PalindromeUtils.isPalindromeByStringBuilder(word));
        System.out.println("Слово " + word + " это палиндром (charArray) ? - " + PalindromeUtils.isPalindromeByCharArray(word));
    }
}
