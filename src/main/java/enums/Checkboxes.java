package enums;

public enum Checkboxes {

    WATER("Water", 0),
    EARTH("Earth", 1),
    WIND("Wind", 2),
    FIRE("Fire", 3);

    public String checkboxValue;
    public int checkboxPosition;

    Checkboxes(String checkboxValue, int checkboxPosition ) {
        this.checkboxValue = checkboxValue;
        this.checkboxPosition = checkboxPosition;
    }

}
