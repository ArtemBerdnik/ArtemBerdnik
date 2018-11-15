package enums.moblie;

public enum Constants {

    PATH_TO_RESOURCES("./src/main/resources/"),
    HTTPS_PREFIX("https://");

    public String value;

    Constants(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
