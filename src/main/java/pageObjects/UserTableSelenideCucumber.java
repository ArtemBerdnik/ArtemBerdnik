package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Usernames;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.id;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Usernames.SERGEY_IVAN;
import static enums.Usernames.getUserIdByName;
import static org.testng.Assert.assertEquals;

public class UserTableSelenideCucumber {

    @FindBy(css = "#user-table tr > td > select")
    private ElementsCollection dropdowns;

    @FindBy(css = "#user-table tr > td > a")
    private ElementsCollection userNames;

    @FindBy(css = "#user-table tr > td > img")
    private ElementsCollection images;

    @FindBy(css = "#user-table tr > td > div > span")
    private ElementsCollection textsUnderImages;

    @FindBy(css = "#user-table tr > td > div > input")
    private ElementsCollection checkboxesUnderImages;

    @FindBy(css = "[type ='checkbox']")
    private ElementsCollection VIPcheckboxes;

    @FindBy(css = "[class='panel-body-list logs'] > li")
    private ElementsCollection logs;

    @FindBy(css = "tbody > tr:nth-child(2) option")
    private ElementsCollection optionsInDropdown;

    public UserTableSelenideCucumber() {
        page(this);
    }
    //===============================methods========================================

    @When("^I select 'vip' checkbox for \"([^\"]*)\"$")
    public void selectVipCheckbox(String name) {
        VIPcheckboxes.findBy(id(getUserIdByName(name))).click();
    }

    @When("^I click on dropdown in column Type for user Roman$")
    public void iClickOnDropdownInColumnTypeForUserRoman() {
        dropdowns.first().click();
    }

    //===============================checks==========================================
    @Then("^\"([^\"]*)\" page is opened$")
    public void checkUserTablePageIsOpened(String pageName) {
        assertEquals(getWebDriver().getTitle(), (pageName));
    }

    @And("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void checkAmountOfNumberTypeDropdowns(int amountOfDropdowns) {
        dropdowns.shouldHaveSize(amountOfDropdowns);
    }

    @And("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void checkAmountOfUsernames(int amountOfUsernames) {
        userNames.shouldHaveSize(amountOfUsernames);
    }

    @And("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void checkAmountOfImages(int amountOfImages) {
        images.shouldHaveSize(amountOfImages);
    }

    @And("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void checkAmountOfTextsUnderImages(int amountOfTextsUnderImages) {
        textsUnderImages.shouldHaveSize(amountOfTextsUnderImages);
    }

    @And("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkAmountOfCheckboxesUnderImages(int amountOfCheckboxesUnderImages) {
        checkboxesUnderImages.shouldHaveSize(amountOfCheckboxesUnderImages);
    }

    @And("^User table contains following values:$")
    public void checkValuesInUsersTable(DataTable table) {
        List<Map<String, String>> list = table.asMaps(String.class, String.class);

        for (Map<String, String> options : list) {
            userNames.findBy(text(options.get("User"))).shouldHave(text(options.get("User")));
            textsUnderImages.findBy(text(options.get("Description"))).shouldHave(text(options.get("Description")));
        }
    }

    @Then("^(\\d+) log row has \"([^\"]*)\" text in log section$")
    public void logRowHasTextInLogSection(int numberOfRows, String text) {
        logs.shouldHaveSize(numberOfRows);
        logs.shouldHave(texts(text));
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(DataTable optionsUnderDropdown) {
        List<String> options = optionsUnderDropdown.asList();
        for (int i = 1; i < options.size(); i++) {
            optionsInDropdown.get(i-1).shouldHave(text(options.get(i)));
        }
    }
}
