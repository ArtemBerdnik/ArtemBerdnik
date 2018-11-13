package hw5;

import base.TestNGBaseHW5;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsSelenideAllureAnnotations;
import pageObjects.HomePageSelenideAllureAnnotations;

import static com.codeborne.selenide.Selenide.page;
import static enums.Checkboxes.WATER;
import static enums.Checkboxes.WIND;
import static enums.Colors.RED;
import static enums.Colors.YELLOW;
import static enums.Radiobuttons.SELEN;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Service Page")
@Story("Different Elements Page Testing")
@Listeners(AllureAttachmentListener.class)
public class ServicePageInterfaceCheck extends TestNGBaseHW5 {

    private HomePageSelenideAllureAnnotations homePage;
    private DifferentElementsSelenideAllureAnnotations differentElementsPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenideAllureAnnotations.class);
        differentElementsPage = page(DifferentElementsSelenideAllureAnnotations.class);
    }

    @Test
    public void checkDifferentElementsPage() {
        //1. Open test site by URL
        homePage.openHomePage();

        //2. Assert Browser title
        homePage.checkTitle();

        //3. Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePage.checkDisplayedUserName();

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkSubcategoriesUnderServiceDropdownInHeader();

        //6. Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkSubcategoriesUnderServiceDropdownInLeftPanel();

        //7. Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPage();

        //8. Check interface on Different elements page, it contains all needed elements (4 checkboxes, 4 radios, 1 dropdown, 2 buttons)
        differentElementsPage.checkControlsOnDifferentElementsPage();

        //9. Assert that there is Right Section
        differentElementsPage.checkRightSectionIsDisplayed();

        //10. Assert that there is Left Section
        differentElementsPage.checkLeftSectionIsDisplayed();

        //11. Select checkboxes (Water, Wind)
        differentElementsPage.selectCheckboxes(WATER, WIND);

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkInfoInLogAboutSelectedCheckbox(WATER, WIND);

        //13. Select radio (Selen)
        differentElementsPage.selectRadiobutton(SELEN);

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.checkInfoInLogAboutSelectedRadiobutton(SELEN);

        //15. Select in dropdown (Yellow)
        differentElementsPage.selectColorInDropdown(YELLOW);

        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsPage.checkInfoInLogAboutSelectedColor(RED);

        //17. Unselect and assert checkboxes
        differentElementsPage.selectCheckboxes(WATER, WIND);

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkInfoInLogAboutSelectedCheckbox(WATER, WIND);
    }
}