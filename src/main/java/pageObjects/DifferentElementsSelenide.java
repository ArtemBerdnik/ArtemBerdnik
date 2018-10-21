package pageObjects;

import com.codeborne.selenide.SelenideElement;
import enums.Checkboxes;
import enums.Colors;
import enums.Radiobuttons;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DifferentElementsSelenide {

    @FindBy(css = "[class='label-checkbox']")
    private List<SelenideElement> checkboxesOnDifferentElementsPage;

    @FindBy(css = "[class='label-radio']")
    private List<SelenideElement> radiobuttonsOnDifferentElementsPage;

    @FindBy(css = "select[class='uui-form-element']")
    private SelenideElement dropdownWithColors;

    @FindBy(name = "Default Button")
    private SelenideElement defaultButton;

    @FindBy(css = "input[type='button']")
    private SelenideElement button;

    @FindBy(name = "navigation-sidebar")
    private SelenideElement leftSection;

    @FindBy(name = "log-sidebar")
    private SelenideElement rightSection;

    @FindBy(css = "[class='panel-body-list logs'] > li:first-child")
    private SelenideElement firstRowInLog;

    @FindBy(css = "[class='label-checkbox'] > input")
    private List<SelenideElement> statusOfcheckboxes;

    @FindBy(css = "[type = 'radio']")
    private List<SelenideElement> statusOfRadiobuttons;

    @FindBy(css = "select[class='uui-form-element'] option")
    private List<SelenideElement> availableColors;

    @FindBy(css = "[class='panel-body-list logs'] li")
    private List<SelenideElement> logs;

    //===============================methods========================================

    public void selectCheckboxes(Checkboxes... checkboxes) {
        for (Checkboxes checkbox : checkboxes) {
            $$(checkboxesOnDifferentElementsPage).findBy(text(checkbox.checkboxValue)).click();
//            $$(statusOfcheckboxes).get(checkbox.checkboxPosition).shouldBe(selected);
        }
    }

    public void selectRadiobutton(Radiobuttons radiobutton) {
        $$(radiobuttonsOnDifferentElementsPage).findBy(text(radiobutton.radiobuttonValue)).click();
        $$(statusOfRadiobuttons).get(radiobutton.radiobuttonPosition).shouldBe(selected);
    }

    public void selectColorInDropdown(Colors color) {
        dropdownWithColors.click();
        $$(availableColors).findBy(text(color.colorValue)).click();
    }

    //===============================checks==========================================

    public void checkControlsOnDifferentElementsPage() {
        $$(checkboxesOnDifferentElementsPage).shouldHaveSize(4);
        $$(checkboxesOnDifferentElementsPage).shouldHave(texts("Water", "Earth", "Wind", "Fire"));

        $$(radiobuttonsOnDifferentElementsPage).shouldHaveSize(4);
        $$(radiobuttonsOnDifferentElementsPage).shouldHave(texts("Gold", "Silver", "Bronze", "Selen"));

        $(dropdownWithColors).shouldBe(enabled);
        $(defaultButton).isDisplayed();
        $(button).isDisplayed();
    }

    public void checkRightSectionIsDisplayed() {
        $(rightSection).isDisplayed();
    }

    public void checkLeftSectionIsDisplayed() {
        $(leftSection).isDisplayed();
    }

    public void checkInfoInLogAboutSelectedCheckbox(Checkboxes... checkboxes) {
        for (Checkboxes checkbox : checkboxes) {
            if (!$$(statusOfcheckboxes).get(checkbox.checkboxPosition).isSelected()) {
                $$(logs).findBy(text(checkbox.checkboxValue)).shouldHave(text(checkbox.checkboxValue + ": condition changed to false"));
            } else {
                $$(logs).findBy(text(checkbox.checkboxValue)).shouldHave(text(checkbox.checkboxValue + ": condition changed to true"));
            }
        }
    }

    public void checkInfoInLogAboutSelectedRadiobutton(Radiobuttons radiobutton) {
        $(firstRowInLog).shouldHave(text("metal: value changed to " + radiobutton.radiobuttonValue));
    }

    public void checkInfoInLogAboutSelectedColor(Colors color) {
        $(firstRowInLog).shouldHave(text("Colors: value changed to " + color.colorValue));
    }
}
