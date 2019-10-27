package ru.anovikova.lesson22;

import java.util.Comparator;

public class PersonSuperComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int nameScore = o1.getName().compareTo(o2.getName());
        if (nameScore == 0) {
            if (o1.getAge() == o2.getAge()) {
                return 0;
            } else {
                return  (o1.getAge() > o2.getAge()) ? 1 : -1;
            }
        }
        return nameScore;
    }
}
