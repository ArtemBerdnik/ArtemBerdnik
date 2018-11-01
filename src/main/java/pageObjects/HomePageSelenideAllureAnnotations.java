package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.SubcategoriesUnderServiceDropdown.*;
import static enums.Urls.HOME_PAGE;
import static org.testng.Assert.assertEquals;

public class HomePageSelenideAllureAnnotations {

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

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8'] > [class='dropdown']")
    private SelenideElement serviceDropdownInPageHeader;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']  a[class]")
    private SelenideElement ServiceDropdownInHeader;

    @FindBy(css = "[class='dropdown open'] li")
    private ElementsCollection subcategoriesUnderServiceDropdownInHeader;

    @FindBy(css = "li[class='menu-title'][index='3']")
    private SelenideElement ServiceDropdownInLeftPanel;

    @FindBy(css = "[class='sub'] span")
    private ElementsCollection subcategoriesUnderServiceDropdownInLeftPanel;

    //===============================methods========================================
    @Step
    public void openHomePage() {
        open(HOME_PAGE.getUrl);
    }

    @Step
    public void login(Users user) {
        userIcon.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submitButton.click();
    }

    @Step
    public void openDifferentElementsPage() {
        ServiceDropdownInHeader.click();
        subcategoriesUnderServiceDropdownInHeader.findBy(text(DIFFERENT_ELEMENTS.name)).click();
    }

    public void openDatesPage() {
        ServiceDropdownInHeader.click();
        subcategoriesUnderServiceDropdownInHeader.findBy(text(DATES.name)).click();
    }

    //===============================checks==========================================
    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    @Step
    public void checkDisplayedUserName() {
        userName.shouldHave(text("PITER CHAILOVSKII"));
    }

    @Step
    public void checkSubcategoriesUnderServiceDropdownInHeader() {
        ServiceDropdownInHeader.click();
        subcategoriesUnderServiceDropdownInHeader.shouldHaveSize(8);
        subcategoriesUnderServiceDropdownInHeader.shouldHave(texts(getSubcategoriesNames()));
    }

    @Step
    public void checkSubcategoriesUnderServiceDropdownInLeftPanel() {
        ServiceDropdownInLeftPanel.click();
        subcategoriesUnderServiceDropdownInLeftPanel.shouldHaveSize(8);
        subcategoriesUnderServiceDropdownInLeftPanel.shouldHave(texts(getSubcategoriesNames()));
    }
}
