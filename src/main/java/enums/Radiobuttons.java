package enums;

import java.util.ArrayList;
import java.util.List;

public enum Radiobuttons {

    GOLD("Gold", 0),
    SILVER("Silver", 1),
    BRONZE("Bronze", 2),
    SELEN("Selen", 3);

    public String radiobuttonValue;
    public int radiobuttonPosition;

    Radiobuttons(String radiobuttonValue, int radiobuttonPosition) {
        this.radiobuttonValue = radiobuttonValue;
        this.radiobuttonPosition = radiobuttonPosition;
    }

    public static List<String> getRadiobuttonsNames() {
        List<String> radiobuttonsNames = new ArrayList<>();
        for (Radiobuttons radio : Radiobuttons.values()) {
            radiobuttonsNames.add(radio.radiobuttonValue);
        }
        return radiobuttonsNames;
    }
}
