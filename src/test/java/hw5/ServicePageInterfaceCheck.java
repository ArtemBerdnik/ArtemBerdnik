package hw5;

import base.TestNGBaseHW5;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsSelenide;
import pageObjects.DifferentElementsSelenideAllureAnnotations;
import pageObjects.IndexPageSelenide;
import pageObjects.IndexPageSelenideAllureAnnotations;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Checkboxes.FIRE;
import static enums.Checkboxes.WATER;
import static enums.Checkboxes.WIND;
import static enums.Colors.YELLOW;
import static enums.Radiobuttons.SELEN;
import static enums.Urls.INDEX_PAGE;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Service Page")
@Story("Different Elements Page Testing")
@Listeners(AllureAttachmentListener.class)
public class ServicePageInterfaceCheck extends TestNGBaseHW5 {

    private IndexPageSelenideAllureAnnotations indexPage;
    private DifferentElementsSelenideAllureAnnotations differentElementsSelenide;

    @BeforeClass
    public void beforeClass() {
        indexPage = page(IndexPageSelenideAllureAnnotations.class);
        differentElementsSelenide = page(DifferentElementsSelenideAllureAnnotations.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        open(INDEX_PAGE.getUrl);
        getWebDriver().manage().window().maximize();
    }

    @Test
    public void checkDifferentElementsPage() {
        //2. Assert Browser title
        indexPage.checkTitle();

        //3. Perform login
        indexPage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        indexPage.checkDisplayedUserName();

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.checkSubcategoriesUnderServiceDropdownInHeader();

        //6. Click on Service subcategory in the left section and check that drop down contains options
        indexPage.checkSubcategoriesUnderServiceDropdownInLeftPanel();

        //7. Open through the header menu Service -> Different Elements Page
        indexPage.openDifferentElementsPage();

        //8. Check interface on Different elements page, it contains all needed elements (4 checkboxes, 4 radios, 1 dropdown, 2 buttons)
        differentElementsSelenide.checkControlsOnDifferentElementsPage();

        //9. Assert that there is Right Section
        differentElementsSelenide.checkRightSectionIsDisplayed();

        //10. Assert that there is Left Section
        differentElementsSelenide.checkLeftSectionIsDisplayed();

        //11. Select checkboxes (Water, Wind)
        differentElementsSelenide.selectCheckboxes(WATER, WIND);

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsSelenide.checkInfoInLogAboutSelectedCheckbox(WATER, WIND);

        //13. Select radio (Selen)
        differentElementsSelenide.selectRadiobutton(SELEN);

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsSelenide.checkInfoInLogAboutSelectedRadiobutton(SELEN);

        //15. Select in dropdown (Yellow)
        differentElementsSelenide.selectColorInDropdown(YELLOW);

        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsSelenide.checkInfoInLogAboutSelectedColor(YELLOW);

        //17. Unselect and assert checkboxes
        differentElementsSelenide.selectCheckboxes(WATER, WIND);

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsSelenide.checkInfoInLogAboutSelectedCheckbox(WATER, WIND);
    }
}