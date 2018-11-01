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

    public static String getUserIdByName(String name) {
        for (Usernames user : Usernames.values()) {
            if (user.name.equals(name)){
                return user.id;
            }
        }
        return null;
    }
}
