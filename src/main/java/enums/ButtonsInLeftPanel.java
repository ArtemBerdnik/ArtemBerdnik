package enums;

public enum ButtonsInLeftPanel {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_COLORS("Metals & Colors"),
    ELEMENTS_PACK("Elements pack");

    public String name;

    ButtonsInLeftPanel(String name) {
        this.name = name;
    }

    public static String getButtonByName(String name) {
        for (ButtonsInLeftPanel button : ButtonsInLeftPanel.values()) {
            if (button.name.equals(name)) {
                return button.name;
            }
        }
        return null;
    }
}
