package jdi.site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import jdi.entities.MetalsAndColorsData;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static jdi.enums.VegetablesEnum.DEFAULT_VEGETABLE;

public class MetalColorForm extends Form<MetalsAndColorsData> {

    @Css(".vertical-group label")
    private CheckList elements;

    @FindBy(css = "button#submit-button")
    private Button submit;

//    @JDropdown(
//            root = @FindBy(id = "salad-dropdown"),
//            list = @FindBy(tagName = "li"),
//            value = @FindBy(className = "checkbox")
//    )
//    private Dropdown vegetables;

    @FindBy(css = "#salad-dropdown button")
    private Label checkedVegetables;

    @FindBy(css = "#salad-dropdown label")
    private CheckList vegetables;

    @JDropdown(
            root = @FindBy(id = "colors"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    private Dropdown colors;

    @JDropdown(
            root = @FindBy(id = "metals"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button"),
            expand = @FindBy(css = ".caret")
    )
    private Dropdown metals;

    private SummaryForm summaryForm;

    @Step
    public void fillData(MetalsAndColorsData data) {
        summaryForm.submit(data);
        elements.check(data.getElements());
        colors.select(data.getColor());
        metals.select(data.getMetals());
        checkedVegetables.click();
        vegetables.check(DEFAULT_VEGETABLE.text);
        for (String vegetable : data.getVegetables()) {
            vegetables.check(vegetable);
        }
    }

    @Step
    public void submit() {
        submit.click();
    }
}

