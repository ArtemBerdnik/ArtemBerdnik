package pageObjects;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Usernames;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Usernames.SERGEY_IVAN;
import static org.testng.Assert.assertEquals;

public class UserTableSelenideCucumber {


    @FindBy(css = "#user-table tr > td > select")
    private List<SelenideElement> dropdowns;

    @FindBy(css = "#user-table tr > td > a")
    private List<SelenideElement> userNames;

    @FindBy(css = "#user-table tr > td > img")
    private List<SelenideElement> images;

    @FindBy(css = "#user-table tr > td > div > span")
    private List<SelenideElement> textsUnderImages;

    @FindBy(css = "#user-table tr > td > div > input")
    private List<SelenideElement> checkboxesUnderImages;

    @FindBy(css = "[type ='checkbox']")
    private List<SelenideElement> VIPcheckboxes;

    public UserTableSelenideCucumber() {
        page(this);
    }
    //===============================methods========================================

    @When("^I select 'vip' checkbox for \"([^\"]*)\"$")
    public void selectVipCheckbox(String name) {
        $$(VIPcheckboxes).findBy(id("ivan")).click();
    }
    //===============================checks==========================================
    @Then("^\"([^\"]*)\" page is opened$")
    public void checkUserTablePageIsOpened(String pageName) {
        assertEquals(getWebDriver().getTitle(), (pageName));
    }

    @And("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void checkAmountOfNumberTypeDropdowns(int amountOfDropdowns) {
        $$(dropdowns).shouldHaveSize(amountOfDropdowns);
    }

    @And("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void checkAmountOfUsernames(int amountOfUsernames) {
        $$(userNames).shouldHaveSize(amountOfUsernames);
    }

    @And("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void checkAmountOfImages(int amuntOfImages) {
        $$(images).shouldHaveSize(amuntOfImages);
    }

    @And("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void checkAmountOfTextsUnderImages(int amountOfTextsUnderImages) {
        $$(textsUnderImages).shouldHaveSize(amountOfTextsUnderImages);
    }

    @And("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkAmountOfCheckboxesUnderImages(int amountOfCheckboxesUnderImages) {
        $$(checkboxesUnderImages).shouldHaveSize(amountOfCheckboxesUnderImages);
    }

    @And("^User table contains following values:$")
    public void checkValuesInUsersTable(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> aList : list) {
            $$(userNames).findBy(text(aList.get("User"))).shouldHave(text(aList.get("User")));
            $$(textsUnderImages).findBy(text(aList.get("Description"))).shouldHave(text(aList.get("Description")));
        }

//        $$(userNames).findBy(text(String.valueOf(number))).shouldHave(text(String.valueOf(userName)));
//        $$(textsUnderImages).findBy(text(String.valueOf(number))).shouldHave(text(String.valueOf(desription)));
    }

}
