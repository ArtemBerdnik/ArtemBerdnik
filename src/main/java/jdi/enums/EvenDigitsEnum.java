package jdi.enums;

public enum EvenDigitsEnum {
    DEFAULT_SUM("3", 3),
    DEFAULT_EVEN("2", 2),
    TWO("2", 2),
    FOUR("4", 4),
    SIX("6", 6),
    EIGHT("8", 8);

    public final String text;
    public final int digit;

    EvenDigitsEnum(String text, int digit) {
        this.text = text;
        this.digit = digit;
    }
}
