package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
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

    public void openDatesPage() {
        ServiceDropdownInHeader.click();
        $$(subcategoriesUnderServiceDropdownInHeader).get(1).click();
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
}
