package jdi.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import jdi.entities.MetalsAndColorsData;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.epam.web.matcher.testng.ScreenAssert.assertEquals;
import static jdi.utils.ExpectedResultsCreator.getExpectedResultText;

public class LeftPanel extends Section {

    @FindBy(css = ".results li")
    private TextList resultsList;

    @Step
    public void compareResults(MetalsAndColorsData data) {
        assertEquals(resultsList.getValue(), getExpectedResultText(data));
    }
}
