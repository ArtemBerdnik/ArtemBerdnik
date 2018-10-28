package pageObjects;

import com.codeborne.selenide.SelenideElement;
import enums.Checkboxes;
import enums.Colors;
import enums.Radiobuttons;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DifferentElementsSelenideAllureAnnotations {

    @FindBy(css = "[class='label-checkbox']")
    private List<SelenideElement> checkboxesOnDifferentElementsPage;

    @FindBy(css = "[class='label-radio']")
    private List<SelenideElement> radiobuttonsOnDifferentElementsPage;

    @FindBy(css = "select[class='uui-form-element']")
    private SelenideElement dropdownWithColors;

    @FindBy(css = "[name = 'Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "input[type='button']")
    private SelenideElement button;

    @FindBy(css = "[name = 'navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = "[name = 'log-sidebar']")
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

    @Step
    public void selectCheckboxes(Checkboxes... checkboxes) {
        for (Checkboxes checkbox : checkboxes) {
            $$(checkboxesOnDifferentElementsPage).findBy(text(checkbox.checkboxValue)).click();
        }
    }

    @Step
    public void selectRadiobutton(Radiobuttons radiobutton) {
        $$(radiobuttonsOnDifferentElementsPage).findBy(text(radiobutton.radiobuttonValue)).click();
        $$(statusOfRadiobuttons).get(radiobutton.radiobuttonPosition).shouldBe(selected);
    }

    @Step
    public void selectColorInDropdown(Colors color) {
        dropdownWithColors.click();
        $$(availableColors).findBy(text(color.colorValue)).click();
    }

    //===============================checks==========================================

    @Step
    public void checkControlsOnDifferentElementsPage() {
        $$(checkboxesOnDifferentElementsPage).shouldHaveSize(4);
        $$(checkboxesOnDifferentElementsPage).shouldHave(texts("Water", "Earth", "Wind", "Fire"));

        $$(radiobuttonsOnDifferentElementsPage).shouldHaveSize(4);
        $$(radiobuttonsOnDifferentElementsPage).shouldHave(texts("Gold", "Silver", "Bronze", "Selen"));

        dropdownWithColors.shouldBe(enabled);
        defaultButton.isDisplayed();
        button.isDisplayed();
    }

    @Step
    public void checkRightSectionIsDisplayed() {
        $(rightSection).isDisplayed();
    }

    @Step
    public void checkLeftSectionIsDisplayed() {
        $(leftSection).isDisplayed();
    }

    @Step
    public void checkInfoInLogAboutSelectedCheckbox(Checkboxes... checkboxes) {
        for (Checkboxes checkbox : checkboxes) {
            if (!$$(statusOfcheckboxes).get(checkbox.checkboxPosition).isSelected()) {
                $$(logs).findBy(text(checkbox.checkboxValue)).shouldHave(text(checkbox.checkboxValue + ": condition changed to false"));
            } else {
                $$(logs).findBy(text(checkbox.checkboxValue)).shouldHave(text(checkbox.checkboxValue + ": condition changed to true"));
            }
        }
    }

    @Step
    public void checkInfoInLogAboutSelectedRadiobutton(Radiobuttons radiobutton) {
        firstRowInLog.shouldHave(text("metal: value changed to " + radiobutton.radiobuttonValue));
    }

    @Step
    public void checkInfoInLogAboutSelectedColor(Colors color) {
        firstRowInLog.shouldHave(text("Colors: value changed to " + color.colorValue));
    }
}