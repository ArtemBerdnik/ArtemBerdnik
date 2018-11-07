package jdi.utils;

import jdi.entities.MetalsAndColorsData;
import org.testng.util.Strings;

public class ExpectedResultsCreator {

    public static String getExpectedResultText(MetalsAndColorsData data) {
        String summaryRow = "Summary: " + (data.getSummary()[0] + data.getSummary()[1]);
        String elements = (data.getElements().length == 1) ? "Elements: " + data.getElements()[0] : "Elements: " + Strings.join(", ", data.getElements());
        String vegetableRow = (data.getVegetables().length == 1) ? "Vegetables: " + data.getVegetables()[0] : "Vegetables: " + Strings.join(", ", data.getVegetables());
        String colorRow = "Color: " + data.getColor();
        String metalRow = "Metal: " + data.getMetals();

        return summaryRow + ", " +
                elements + ", " +
                colorRow + ", " +
                metalRow + ", " +
                vegetableRow;
    }
}
