package hw4;

import base.TestNGBaseHW4;
import org.testng.annotations.Test;

import static enums.Users.PITER_CHAILOVSKII;

public class DataPageSliderCheck extends TestNGBaseHW4 {

    @Test
    public void checkSlidersOnDataPage() {
        //2. Assert Browser title
        indexPage.checkTitle();

        //3. Perform login
        indexPage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        indexPage.checkDisplayedUserName();

        //5. Open through the header menu Service -> Dates Page
        indexPage.openDatesPage();

        //6. Using drag-and-drop set Range sliders. (0-100)
    }
}
