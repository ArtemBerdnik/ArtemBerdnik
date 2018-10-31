package jdi.site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import jdi.entities.MetalsAndColorsData;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class SummaryForm extends Form<MetalsAndColorsData> {

    @FindBy(css = "#odds-selector label")
    private RadioButtons oddsRadioButton;

    @FindBy(css = "#even-selector label")
    private RadioButtons evenRadioButton;

    @Css("#calculate-button")
    private Button calculatingButton;

    @Step
    public void submit(MetalsAndColorsData data) {
        if (data.getOddsRadioButton() != null) {
            oddsRadioButton.select(data.getOddsRadioButton());
        }
        if (data.getEvenRadioButton() != null) {
            evenRadioButton.select(data.getEvenRadioButton());
        }
        calculatingButton.click();
    }
}
