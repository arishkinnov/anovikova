package ru.anovikova.lesson19;

public enum FieldType {
    TITLE(0), AMOUNT(1), PRICE(2);

    private final int index;

    FieldType(int index) {
        this.index = index;
    }

    public static FieldType findByIndex(int index) {
        for (FieldType fieldType : FieldType.values()) {
            if (fieldType.index == index) {
                return fieldType;
            }
        }
        throw new IllegalStateException("Undefined index");
    }
}
