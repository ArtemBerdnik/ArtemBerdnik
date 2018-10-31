package jdi.enums;

public enum VegetablesEnum {
    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    DEFAULT_VEGETABLE("Vegetables"),
    ONION("Onion");

    public String text;

    VegetablesEnum(String text) {
        this.text = text;
    }
}
