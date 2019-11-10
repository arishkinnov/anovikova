package ru.anovikova.lesson24;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashSet<String> original = new HashSet(Arrays.asList("foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"));
        System.out.println("original = " + original);
        Set<String> filtered = SetUtils.removeEvenLengthAndReturnCopy(original);
        System.out.println("original = " + original);
        System.out.println("filtered = " + filtered);
        Set<String> filtered1 = SetUtils.removeEvenLength(original);
        System.out.println("original = " + original);
        System.out.println("filtered1 = " + filtered1);
    }
}
