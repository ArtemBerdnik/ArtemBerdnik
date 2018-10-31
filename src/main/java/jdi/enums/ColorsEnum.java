package jdi.enums;

public enum  ColorsEnum {
    DEFAULT_COLOR("Colors"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public final String text;

    ColorsEnum(String text) {
        this.text = text;
    }
}
