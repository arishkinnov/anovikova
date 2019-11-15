package ru.anovikova.lesson31;

public class PalindromeUtils {
    public static boolean isPalindromeByCharArray(String text) {
        char[] chars = text.toCharArray();
        int maxIteration = getMaxIteration(chars.length);
        int lastIndex = chars.length - 1;
        for (int index = 0; index < maxIteration; index++) {
            if (chars[index] != chars[lastIndex - index]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeByStringBuilder(String text) {
        StringBuilder strBuilder = new StringBuilder(text);
        strBuilder.reverse();
        String invertedText = strBuilder.toString();
        return text.equalsIgnoreCase(invertedText) ;
    }

    private static int getMaxIteration(int arrayLength) {
        boolean isEvenLength = arrayLength % 2 == 0;
        int maxIteration;
        if (isEvenLength) {
            maxIteration = arrayLength / 2;
        } else {
            maxIteration = (arrayLength - 1) / 2;
        }
        return maxIteration;
    }
}
