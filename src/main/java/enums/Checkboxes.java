package enums;

import java.util.ArrayList;
import java.util.List;

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

    public static List<String> getCheckboxesNames() {
        List<String> checkboxNames = new ArrayList<>();
        for (Checkboxes category : Checkboxes.values()) {
            checkboxNames.add(category.checkboxValue);
        }
        return checkboxNames;
    }
}
