package ru.anovikova.lesson25.task1;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> firstMap = new HashMap<String, String>(){{
            put("Вася", "Иванов");
            put("Петр", "Петров");
            put("Виктор", "Сидоров");
            put("Сергей", "Савельев");
            put("Вадим", "Викторов");
        }};

        HashMap<String, String> secondMap = new HashMap<String, String>(){{
            put("Вася","Иванов");
            put("Петр","Петров");
            put("Виктор","Иванов");
            put("Сергей","Савельев");
            put("Вадим","Петров");
        }};

        System.out.println("firstMap is unique (use set): " + MapUtils.isUniqueUsingSet(firstMap));
        System.out.println("secondMap is unique (use set): " + MapUtils.isUniqueUsingSet(secondMap));

        System.out.println("firstMap is unique (use list): " + MapUtils.isUniqueUsingList(firstMap));
        System.out.println("secondMap is unique (use list): " + MapUtils.isUniqueUsingList(secondMap));
    }
}
