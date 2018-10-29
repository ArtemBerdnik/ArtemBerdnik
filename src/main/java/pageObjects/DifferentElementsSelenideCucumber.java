package pageObjects;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Checkboxes;
import enums.Colors;
import enums.Radiobuttons;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class DifferentElementsSelenideCucumber {

//    @After(order = 10)
//    public void closeWebDriver() {
//        if (getWebDriver() != null) {
//            getWebDriver().manage().deleteAllCookies();
//            WebDriverRunner.closeWebDriver();
//        }
//    }

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

    @FindBy(css = "[class='uui-button']")
    private List<SelenideElement> buttonsOnDifferentElementsPage;

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

    public DifferentElementsSelenideCucumber() {
        page(this);
    }

    //===============================methods========================================

    @When("^I select checkboxes \"([^\"]*)\" and \"([^\"]*)\"$")
    public void selectCheckboxes(String checkbox1, String checkbox2) {
        $$(checkboxesOnDifferentElementsPage).findBy(text(Checkboxes.valueOf(checkbox1).checkboxValue)).click();
        $$(checkboxesOnDifferentElementsPage).findBy(text(Checkboxes.valueOf(checkbox2).checkboxValue)).click();
    }

    @When("^I unselected checkboxes \"([^\"]*)\" and \"([^\"]*)\"$")
    public void unselectCheckboxes(String checkbox1, String checkbox2) {
        List<String> checkboxes = Arrays.asList(checkbox1,checkbox2);
        for (String checkbox : checkboxes) {
            $$(checkboxesOnDifferentElementsPage).findBy(text(Checkboxes.valueOf(checkbox).checkboxValue)).click();
        }
    }

    @When("I select radiobutton \"([^\"]*)\"")
    public void selectRadiobutton(String radiobutton) {
        $$(radiobuttonsOnDifferentElementsPage).findBy(text(Radiobuttons.valueOf(radiobutton).radiobuttonValue)).click();
        $$(statusOfRadiobuttons).get(Radiobuttons.valueOf(radiobutton).radiobuttonPosition).shouldBe(selected);
    }

    @When("I select \"([^\"]*)\" in dropdown")
    public void selectColorInDropdown(String color) {
        dropdownWithColors.click();
        $$(availableColors).findBy(text(Colors.valueOf(color).colorValue)).click();
    }

    //===============================checks==========================================

    @Then("'Different Elements Page' should be opened")
    public void checkDifferentElementsPage() {
        assertEquals(getWebDriver().getTitle(), ("Different Elements"));
    }

    @And("^The following elements should be displayed on 'Different elements page': (\\d+) checkboxes, (\\d+) radiobuttons, dropdown with colors, (\\d+) buttons$")
    public void checkControlsOnDifferentElementsPage(int amountOfCheckboxes, int amountOfRadiobuttons, int amountOfButtons) {
        $$(checkboxesOnDifferentElementsPage).shouldHaveSize(amountOfCheckboxes);
        $$(checkboxesOnDifferentElementsPage).shouldHave(texts("Water", "Earth", "Wind", "Fire"));

        $$(radiobuttonsOnDifferentElementsPage).shouldHaveSize(amountOfRadiobuttons);
        $$(radiobuttonsOnDifferentElementsPage).shouldHave(texts("Gold", "Silver", "Bronze", "Selen"));

        dropdownWithColors.shouldBe(enabled);

        $$(buttonsOnDifferentElementsPage).shouldHaveSize(amountOfButtons);
        defaultButton.isDisplayed();
        button.isDisplayed();
    }

    @And("Right Section should be displayed")
    public void checkRightSectionIsDisplayed() {
        $(rightSection).isDisplayed();
    }

    @And("Left Section should be displayed")
    public void checkLeftSectionIsDisplayed() {
        $(leftSection).isDisplayed();
    }

    @Then("\"([^\"]*)\" and \"([^\"]*)\" checkboxes should be checked")
    public void checkSelectedCheckboxes(String checkbox1, String checkbox2) {
        List<String> checkboxes = Arrays.asList(checkbox1,checkbox2);
        for (String checkbox : checkboxes) {
            $$(statusOfcheckboxes).get(Checkboxes.valueOf(checkbox).checkboxPosition).shouldBe(selected);
        }
    }

    @And("^The log should have individual entry with value which is corresponded to the status of the \"([^\"]*)\" and \"([^\"]*)\" checkboxes$")
    public void checkInfoInLogAboutSelectedCheckbox(String checkbox1, String checkbox2) {
        List<String> checkboxes = Arrays.asList(checkbox1,checkbox2);
        for (String checkbox : checkboxes) {
            if (!$$(statusOfcheckboxes).get(Checkboxes.valueOf(checkbox).checkboxPosition).isSelected()) {
                $$(logs).findBy(text(Checkboxes.valueOf(checkbox).checkboxValue)).shouldHave(text(Checkboxes.valueOf(checkbox).checkboxValue + ": condition changed to false"));
            } else {
                $$(logs).findBy(text(Checkboxes.valueOf(checkbox).checkboxValue)).shouldHave(text(Checkboxes.valueOf(checkbox).checkboxValue + ": condition changed to true"));
            }
        }
    }

    @Then("^The log should have individual entry with value which is corresponded to the status of the radiobutton \"([^\"]*)\"$")
    public void checkInfoInLogAboutSelectedRadiobutton(String radiobutton) {
        firstRowInLog.shouldHave(text("metal: value changed to " + Radiobuttons.valueOf(radiobutton).radiobuttonValue));
    }

    @Then("^The log should have individual entry with value about selected \"([^\"]*)\" color$")
    public void checkInfoInLogAboutSelectedColor(String color) {
        firstRowInLog.shouldHave(text("Colors: value changed to " + Colors.valueOf(color).colorValue));
    }

    @Then("^checkboxes \"([^\"]*)\" and \"([^\"]*)\" should be unchecked$")
    public void checkboxesShouldBeUnchecked(String checkbox1, String checkbox2) {
        List<String> checkboxes = Arrays.asList(checkbox1,checkbox2);
        for (String checkbox : checkboxes) {
            $$(statusOfcheckboxes).get(Checkboxes.valueOf(checkbox).checkboxPosition).shouldNotBe(selected);
        }
    }
}
