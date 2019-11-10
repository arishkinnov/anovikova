package ru.anovikova.lesson24;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetUtils {

    public static Set<String> removeEvenLengthAndReturnCopy(Set<String> in) {
        HashSet<String> out = new HashSet<>();
        for (String inValue : in) {
            if (inValue.length() % 2 != 0) {
                out.add(inValue);
            }
        }
        return out;
    }

    public static Set<String> removeEvenLength(Set<String> in) {
        for (Iterator<String> iterator = in.iterator(); iterator.hasNext();) {
            String inValue = iterator.next();
            if (inValue.length() % 2 == 0) {
                iterator.remove();
            }
        }
        return in;
    }

}
