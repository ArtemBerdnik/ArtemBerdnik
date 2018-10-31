package jdi.enums;

public enum MetalsEnum {
    DEFAULT_METAL("Col"),
    SELEN("Selen"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze");

    public String text;

    MetalsEnum(String text) {
        this.text = text;
    }
}
