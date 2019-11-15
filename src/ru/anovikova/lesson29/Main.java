package ru.anovikova.lesson29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Person> book = createMap();
        printMap(book);
        removeTheDuplicates(book);
        System.out.println("Duplicate has been removed");
        printMap(book);
    }

    private static void printMap(Map<String, Person> map) {
        for (Map.Entry<String, Person> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + " -> value: " + entry.getValue());
        }
    }

    public static Map<String, Person> createMap()
    {
        Map<String, Person> book = new HashMap<>();
        Person person1 = new Person(29,"Петрова","жен");
        Person person2 = new Person(34, "Сидорова", "жен");
        Person person3 = new Person(34, "Тихонова", "жен");
        Person person4 = new Person(35, "Петров", "муж");
        book.put("Key1", person1);
        book.put("Key2", person1);
        book.put("Key3", person2);
        book.put("Key4", person3);
        book.put("Key5", person4);
        book.put("Key6", person4);
        return book;
    }

    public static void removeTheDuplicates(Map<String, Person> map){
        ArrayList<Person> duplicates = new ArrayList<>();
        ArrayList<Person> unique = new ArrayList<>();
        for (Map.Entry<String, Person> entry : map.entrySet()) {
            if (unique.contains(entry.getValue())) {
                duplicates.add(entry.getValue());
            }
            unique.add(entry.getValue());
        }
        for (Person duplicate : duplicates) {
            removeItemFromMapByValue(map, duplicate);
        }
    }

    public static void removeItemFromMapByValue(Map<String, Person> map, Person value)
    {
        Map<String, Person> copy = new HashMap<>(map);
        for (Map.Entry<String, Person> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
