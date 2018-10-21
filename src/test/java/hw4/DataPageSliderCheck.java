package hw4;

import base.TestNGBaseHW4;
import org.testng.annotations.Test;

import static enums.CoordinatesForRange2Slider.*;
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
        datesPageSelenide.moveSlider(ZERO, HUNDRED);

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkInfoInLogAboutSliders(ZERO, HUNDRED);

        //8. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPageSelenide.moveSlider(ZERO, ZERO);

        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkInfoInLogAboutSliders(ZERO, ZERO);

        //10. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPageSelenide.moveSlider(HUNDRED, HUNDRED);

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkInfoInLogAboutSliders(HUNDRED, HUNDRED);

        //12. Using drag-and-drop set Range sliders. (30-70)
        datesPageSelenide.moveSlider(THIRTY, SEVENTY);

        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkInfoInLogAboutSliders(THIRTY, SEVENTY);

        // FIXME: 21.10.2018 : the bug in the latest step is that when right and left slider controls are in the same position, moving left slider will always logged as value for right one.
    }
}
