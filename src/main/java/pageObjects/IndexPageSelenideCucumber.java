package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Urls.HOME_PAGE;
import static enums.Users.PITER_CHAILOVSKII;
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

    @FindBy(css = "[class='profile-photo'] > [ui = 'label']")
    private SelenideElement userName;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8'] > li")
    private ElementsCollection buttonsInHeader;

    @FindBy(css = ".sidebar-menu > li")
    private ElementsCollection buttonsInLeftMenu;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']  a[class]")
    private SelenideElement serviceDropdownInHeader;

    @FindBy(css = "[class='dropdown open'] li")
    private ElementsCollection subcategoriesUnderServiceDropdownInHeader;

    @FindBy(css = "li[class='menu-title'][index='3']")
    private SelenideElement serviceDropdownInLeftPanel;

    @FindBy(css = "li[class='menu-title'][index='3'] > ul")
    private SelenideElement serviceDropdownInLeftPanelAvailability;

    @FindBy(css = "[class='sub'] span")
    private ElementsCollection subcategoriesUnderServiceDropdownInLeftPanel;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection iconsInTheMiddleOfPage;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsUnderIconsInTheMiddleOfPage;

    @FindBy(css = ".main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    @FindBy(css = ".logout > button")
    private SelenideElement logoutButton;

    public IndexPageSelenideCucumber() {
        page(this);
    }

    //===============================methods========================================
    @Given("I open the Home Page")
    public void openHomePage() {
            open(HOME_PAGE.getUrl);
    }

    @When("I log in as user (.+) with password (.+)")
    public void login(String name, String pass) {
        userIcon.click();
        login.sendKeys(name);
        password.sendKeys(pass);
        submitButton.click();
    }

    @And("^I login as user \"([^\"]*)\"$")
    public void loginAsUser(String name) {
        userIcon.click();
        login.sendKeys(PITER_CHAILOVSKII.login);
        password.sendKeys(PITER_CHAILOVSKII.password);
        submitButton.click();
    }

    @When("I open \"([^\"]*)\" page through the header menu Service")
    public void openDifferentElementsPage(String name) {
        serviceDropdownInHeader.click();
        subcategoriesUnderServiceDropdownInHeader.findBy(text(name)).click();
    }

    public void openDatesPage() {
        serviceDropdownInHeader.click();
        subcategoriesUnderServiceDropdownInHeader.get(1).click();
    }

    @When("I click on \"([^\"]*)\" subcategory in the left section")
    public void clickServiceDropdownInLeftPanel(String name) {
        buttonsInLeftMenu.findBy(text(name)).click();
        //serviceDropdownInLeftPanel.click();
    }

    @When("I click on \"([^\"]*)\" button in Header")
    public void clickServiceSubcategoryInHeader(String name) {
        buttonsInHeader.findBy(text(name)).click();
        //serviceDropdownInHeader.click();
    }

    @And("^I click on \"([^\"]*)\" button in Service dropdown$")
    public void iClickOnButtonInServiceDropdown(String button) {
        subcategoriesUnderServiceDropdownInHeader.find(text(button)).click();
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

    @And("Username should be \"([^\"]*)\"")
    public void checkDisplayedUserName(String name) {
        userName.shouldHave(text(name));
    }

    @And("^The following elements should be displayed: (\\d+) pictures, (\\d+) texts under pictures, headline text and description$")
    public void checkInterfaceInTheIndexPage(int amountOfPictures, int amountOfTextsUnderPictures) {

        iconsInTheMiddleOfPage.shouldHaveSize(amountOfPictures);
        iconsInTheMiddleOfPage.forEach(SelenideElement::isDisplayed);

        textsUnderIconsInTheMiddleOfPage.shouldHaveSize(amountOfTextsUnderPictures);
        textsUnderIconsInTheMiddleOfPage.forEach(SelenideElement::isDisplayed);

        mainTitle.shouldBe(visible);
        mainText.shouldBe(visible);
    }

    @Then("Drop down should contain the following options:")
    public void checkSubcategoriesUnderServiceDropdownInHeader(DataTable dropdownOptions) {
        List<String> options = dropdownOptions.asList();

        //Moved all words to uppercase
        List<String> optionsUpperCase = options.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        if (serviceDropdownInLeftPanelAvailability.getAttribute("class").equals("sub")) {
            subcategoriesUnderServiceDropdownInLeftPanel.shouldHaveSize(8);
            subcategoriesUnderServiceDropdownInLeftPanel.shouldHave(texts(optionsUpperCase));
        } else {
            subcategoriesUnderServiceDropdownInHeader.shouldHaveSize(8);
            subcategoriesUnderServiceDropdownInHeader.shouldHave(texts(optionsUpperCase));
        }
    }
}
