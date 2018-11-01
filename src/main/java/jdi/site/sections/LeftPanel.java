package jdi.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import jdi.entities.MetalsAndColorsData;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.epam.web.matcher.testng.ScreenAssert.assertEquals;

public class LeftPanel extends Section {

    @FindBy(css = ".results li")
    private TextList resultsList;


    private String getExpectedResultText(MetalsAndColorsData data) {
        String summaryRow = "Summary: " + (data.getSummary()[0] + data.getSummary()[1]);
        StringBuilder elements = new StringBuilder("Elements: ");
        for (String s : data.getElements()) {
            elements.append(s).append(", ");
        }
        StringBuilder vegetableRow = new StringBuilder("Vegetables: ");
        for (String s : data.getVegetables()) {
            vegetableRow.append(s).append(", ");
        }

        String colorRow = "Color: " + data.getColor();
        String metalRow = "Metal: " + data.getMetals();

        return summaryRow + ", " +
                elements + "" +
                colorRow + ", " +
                metalRow + ", " +
                vegetableRow.substring(0, vegetableRow.length()-2);
    }

    @Step
    public void compareResults(MetalsAndColorsData data) {
        assertEquals(resultsList.getValue(), getExpectedResultText(data));
    }
}