package enums;

public enum ButtonsInHeader {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_COLORS("Metals & Colors");

   public String name;

    ButtonsInHeader(String name) {
        this.name = name;
    }

    public static String getButtonByName(String name) {
        for (ButtonsInHeader button : ButtonsInHeader.values()) {
            if (button.name.equals(name)){
                return button.name;
            }
        }
        return null;
    }
}
