package hw4;

import base.TestNGBaseHW4;
import org.testng.annotations.Test;

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
    }
}
