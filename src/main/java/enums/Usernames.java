package enums;

public enum Usernames {

    SERGEY_IVAN("Sergey Ivan", "ivan"),
    ROMAN("Roman", "roman");

    public String name;
    public String id;

    Usernames(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
