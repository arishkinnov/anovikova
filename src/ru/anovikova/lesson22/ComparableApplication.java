package ru.anovikova.lesson22;

import java.util.TreeSet;

public class ComparableApplication {

    public static void main(String[] args) {
        Person arina18 = new Person("Arina", 18);
        Person nikita = new Person("Nikita", 10);
        Person arina21 = new Person("Arina", 21);
        TreeSet<Person> sortedPersons = new TreeSet<>(new PersonSuperComparator());

        sortedPersons.add(arina21);
        sortedPersons.add(nikita);
        sortedPersons.add(arina18);

        sortedPersons.stream().forEach(System.out::println);
    }
}
