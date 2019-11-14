package ru.anovikova.lesson25.task1;

import java.util.*;

public class MapUtils {

    public static boolean isUniqueUsingSet(HashMap<String, String> map) {
        Collection<String> values = map.values();
        HashSet<String> unique = new HashSet<>(values);
        return values.size() == unique.size();
    }

    public static boolean isUniqueUsingList(HashMap<String, String> map) {
        Collection<String> values = map.values();

        ArrayList<String> unique = new ArrayList<>();
        for (String value : values) {
            if (unique.contains(value)) {
                return false;
            }
            unique.add(value);
        }
        return true;
    }
}
