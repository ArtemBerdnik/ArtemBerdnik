package pageObjects;

import com.codeborne.selenide.SelenideElement;
import enums.Checkboxes;
import enums.Colors;
import enums.Radiobuttons;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class IndexPageSelenide {

    @FindBy(css = ".profile-photo")
    private SelenideElement userIcon;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submitButton;

    @FindBy(css = "[class=\"profile-photo\"] > [ui = \"label\"]")
    private SelenideElement userName;

    @FindBy(css = "[class=\"uui-navigation nav navbar-nav m-l8\"] > [class=\"dropdown\"]")
    private SelenideElement serviceDropdownInPageHeader;

    @FindBy(css = "[class=\"uui-navigation nav navbar-nav m-l8\"]  a[class]")
    private SelenideElement ServiceDropdownInHeader;

    @FindBy(css = "[class=\"dropdown open\"] li")
    private List<SelenideElement> subcategoriesUnderServiceDropdownInHeader;

    @FindBy(css = "li[class=\"menu-title\"][index=\"3\"]")
    private SelenideElement ServiceDropdownInLeftPanel;

    @FindBy(css = "[class=\"sub\"] span")
    private List<SelenideElement> subcategoriesUnderServiceDropdownInLeftPanel;

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
    public void login(String name, String pass) {
        userIcon.click();
        login.sendKeys(name);
        password.sendKeys(pass);
        submitButton.click();
    }

    public void openDifferentElementsPage() {
        ServiceDropdownInHeader.click();
        $$(subcategoriesUnderServiceDropdownInHeader).get(6).click();
    }

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
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkDisplayedUserName() {
        $(userName).shouldHave(text("PITER CHAILOVSKII"));
    }

    public void checkSubcategoriesUnderServiceDropdownInHeader() {
        ServiceDropdownInHeader.click();
        $$(subcategoriesUnderServiceDropdownInHeader).shouldHaveSize(8);
        $$(subcategoriesUnderServiceDropdownInHeader).shouldHave(texts("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
    }

    public void checkSubcategoriesUnderServiceDropdownInLeftPanel() {
        ServiceDropdownInLeftPanel.click();
        $$(subcategoriesUnderServiceDropdownInLeftPanel).shouldHaveSize(8);
        $$(subcategoriesUnderServiceDropdownInLeftPanel).shouldHave(texts("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
    }

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
