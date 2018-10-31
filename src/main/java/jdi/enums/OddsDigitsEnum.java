package jdi.enums;

public enum OddsDigitsEnum {
    DEFAULT_ODDS("1", 1),
    ONE("1", 1),
    THREE("3", 3),
    FIVE("5", 5),
    SEVEN("7", 7);

    public final String text;
    public final int digit;

    OddsDigitsEnum(String text, int digit) {
        this.text = text;
        this.digit = digit;
    }
}
