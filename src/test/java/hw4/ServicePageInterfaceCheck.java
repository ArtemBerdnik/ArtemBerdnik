package hw4;

import base.TestNGBaseHW4;
import enums.Checkboxes;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import static enums.Checkboxes.FIRE;
import static enums.Checkboxes.WATER;
import static enums.Checkboxes.WIND;
import static enums.Users.PITER_CHAILOVSKII;


public class ServicePageInterfaceCheck extends TestNGBaseHW4 {

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
        indexPage.checkControlsOnDifferentElementsPage();

        //9. Assert that there is Right Section
        indexPage.checkRightSectionIsDisplayed();

        //10. Assert that there is Left Section
        indexPage.checkLeftSectionIsDisplayed();

        //11. Select checkboxes (Water, Wind)
        indexPage.selectCheckboxes(WATER, WIND);

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        indexPage.checkInfoInLogAboutSelectedCheckbox(WATER, FIRE);
    }
}
