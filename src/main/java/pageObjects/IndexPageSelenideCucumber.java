package pageObjects;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.builder.HashCodeExclude;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Urls.INDEX_PAGE;
import static org.testng.Assert.assertEquals;

public class IndexPageSelenideCucumber {

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

    //===============================methods========================================
    @Given("I open the Home Page")
    public void openHomePage() {
        open(INDEX_PAGE.getUrl);
    }

    @When("I log in as user (.+) with password (.+)")
    public void login(String name, String pass) {
        userIcon.click();
        login.sendKeys(name);
        password.sendKeys(pass);
        submitButton.click();
    }

    @When("I open 'Different Elements Page' through the header menu Service")
    public void openDifferentElementsPage() {
        ServiceDropdownInHeader.click();
        $$(subcategoriesUnderServiceDropdownInHeader).get(6).click();
    }

    public void openDatesPage() {
        ServiceDropdownInHeader.click();
        $$(subcategoriesUnderServiceDropdownInHeader).get(1).click();
    }

    //===============================checks==========================================
    @Then("Browser title should be 'Home Page'")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    @Then("The user icon should be displayed on the header")
    public void checkUserIcon() {
        userIcon.shouldBe(visible);
    }

    @And("Username should be 'PITER CHAILOVSKII'")
    public void checkDisplayedUserName() {
        userName.shouldHave(text("PITER CHAILOVSKII"));
    }

    @When("I click on 'Service' subcategory in the header")
    @Then("Drop down should contain the following options:")
    public void checkSubcategoriesUnderServiceDropdownInHeader() {
        ServiceDropdownInHeader.click();
        $$(subcategoriesUnderServiceDropdownInHeader).shouldHaveSize(8);
        $$(subcategoriesUnderServiceDropdownInHeader).shouldHave(texts("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
    }

    @When("I click on Service subcategory in the left section")
    @Then("Drop down should contain the following options:")
    public void checkSubcategoriesUnderServiceDropdownInLeftPanel() {
        ServiceDropdownInLeftPanel.click();
        $$(subcategoriesUnderServiceDropdownInLeftPanel).shouldHaveSize(8);
        $$(subcategoriesUnderServiceDropdownInLeftPanel).shouldHave(texts("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
    }
}
